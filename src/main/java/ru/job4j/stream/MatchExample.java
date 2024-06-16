package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean resultNoneMatch = strings.stream()
                .noneMatch("Шесть"::contains);
        System.out.println(resultNoneMatch);

        boolean resultAnyMatch = strings.stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(resultAnyMatch);

        boolean resultAllMatch = strings.stream()
                .allMatch(element -> element.startsWith("Три"));
        System.out.println(resultAllMatch);

    }
}