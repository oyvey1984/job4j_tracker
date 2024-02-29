package ru.job4j.tracker.output;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {

    @Test
    public void whenItemAscByNameIsOk() {
        List<Item> items = Arrays.asList(
                new Item(59, "Volvo"),
                new Item(99, "BMV"),
                new Item(72, "Audi")
                );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(72, "Audi"),
                new Item(99, "BMV"),
                new Item(59, "Volvo")
        );
        assertThat(items.equals(expected)).isTrue();
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(59, "Volvo"),
                new Item(99, "BMV"),
                new Item(72, "Audi")
                );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(59, "Volvo"),
                new Item(99, "BMV"),
                new Item(72, "Audi")
        );
        assertThat(items.equals(expected)).isTrue();
    }
}