package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemThenShouldFindNewValue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item original = tracker.add(new Item("original"));
        Item updated = new Item("updated");
        updated.setId(original.getId());

        boolean result = tracker.replace(original.getId(), updated);
        Item found = tracker.findById(original.getId());

        assertThat(result).isTrue();
        assertThat(found.getName()).isEqualTo("updated");
    }

    @Test
    public void whenReplaceNonExistentItemThenShouldReturnFalse() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("test");

        boolean result = tracker.replace(-1, item);

        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemThenShouldNotFindIt() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("to delete"));

        tracker.delete(item.getId());
        Item found = tracker.findById(item.getId());

        assertThat(found).isNull();
    }

    @Test
    public void whenDeleteNonExistentItemThenNoError() {
        SqlTracker tracker = new SqlTracker(connection);

        assertThatCode(() -> tracker.delete(-1))
                .doesNotThrowAnyException();
    }

    @Test
    public void whenFindAllThenShouldReturnAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("first"));
        Item second = tracker.add(new Item("second"));

        List<Item> items = tracker.findAll();

        assertThat(items).containsExactlyInAnyOrder(first, second);
    }

    @Test
    public void whenFindAllWithEmptyTableThenShouldReturnEmptyList() {
        SqlTracker tracker = new SqlTracker(connection);

        List<Item> items = tracker.findAll();

        assertThat(items).isEmpty();
    }

    @Test
    public void whenFindByNameThenShouldReturnMatchingItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("test"));
        Item item2 = tracker.add(new Item("test"));
        tracker.add(new Item("other"));

        List<Item> items = tracker.findByName("test");

        assertThat(items).containsExactlyInAnyOrder(item1, item2);
    }

    @Test
    public void whenFindByNameWithNoMatchesThenShouldReturnEmptyList() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("test"));

        List<Item> items = tracker.findByName("nonexistent");

        assertThat(items).isEmpty();
    }

    @Test
    public void whenFindByIdThenShouldReturnCorrectItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item expected = tracker.add(new Item("test"));

        Item actual = tracker.findById(expected.getId());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenFindByIdWithNonExistentIdThenShouldReturnNull() {
        SqlTracker tracker = new SqlTracker(connection);

        Item item = tracker.findById(-1);

        assertThat(item).isNull();
    }

    @Test
    public void whenAddItemThenShouldSetGeneratedId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("test");

        Item added = tracker.add(item);

        assertThat(added.getId()).isNotEqualTo(0);
        assertThat(added.getName()).isEqualTo("test");
    }

    @Test
    public void whenAddItemThenShouldSaveCreatedTimestamp() {
        SqlTracker tracker = new SqlTracker(connection);
        LocalDateTime before = LocalDateTime.now().minusSeconds(1);
        Item item = new Item("test");

        Item added = tracker.add(item);
        LocalDateTime after = LocalDateTime.now().plusSeconds(1);

        assertThat(added.getCreated()).isBetween(before, after);
    }
}