package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");

        BiFunction<Integer, String, String> biFunction  = (key, value) -> key + "_" + value;
        String result = map.computeIfPresent(1, biFunction);
        System.out.println("Current value: " + result);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        Map<String, Integer> map1 = new HashMap<>();
        Function<String, Integer> function = String::length;
        System.out.println("Result: " + map1.computeIfAbsent("Petr", function));
        System.out.println("Result: " + map1.computeIfAbsent("Petr", key -> key.length() + 10));
        map1.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}