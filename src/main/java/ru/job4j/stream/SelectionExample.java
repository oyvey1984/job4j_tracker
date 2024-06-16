package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> result = strings
                .stream()
                .skip(2)
                .toList();
        System.out.println(result);

        List<String> strings1 = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> result1 = strings1
                .stream()
                .limit(3)
                .toList();
        System.out.println(result1);

        List<String> strings2 = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> result2 = strings2
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(result2);

        List<String> strings3 = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String result3 = strings3
                .stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(result3);

        List<String> strings4 = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String result4 = strings4
                .stream()
                .skip(5)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(result4);

        List<String> strings5 = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String result5 = strings5
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(result5);
    }
}