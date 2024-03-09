package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenJobAscByNameJob() {
        int rsl = new JobAscByName().compare(
                new Job("First", 1),
                new Job("Second", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobDescByNameJob() {
        int rsl = new JobDescByName().compare(
                new Job("First", 1),
                new Job("Second", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobAscByPriority() {
        int rsl = new JobAscByPriority().compare(
                new Job("First", 1),
                new Job("Second", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobDescByPriority() {
        int rsl = new JobDescByPriority().compare(
                new Job("First", 1),
                new Job("Second", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

        @Test
    public void whenComparatorAscByNameAndAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}