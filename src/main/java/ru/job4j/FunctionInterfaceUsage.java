package ru.job4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> supplier1 = () -> "New String For Interface";
        System.out.println(supplier1.get());

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supplier = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumer = (first, second) -> System.out.println(first + second);
        Set<String> strings = supplier.get();
        int i = 1;
        for (String string : strings) {
            consumer.accept(i++, " is " + string);
        }
    }
}