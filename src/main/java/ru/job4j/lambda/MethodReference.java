package ru.job4j.lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReference {

    public static void show(Stream<Integer> data) {
        data.forEach(System.out::println);
    }
}