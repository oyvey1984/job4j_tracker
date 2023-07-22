package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {
    @Test
    public void whenExceptionIllegal() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Fact.calc(-5);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void whenFactIsSix() {
        int expected = 6;
        int result = Fact.calc(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenFactIsTwo() {
        int expected = 2;
        int result = Fact.calc(2);
        assertThat(result).isEqualTo(expected);
    }
}