package ru.job4j.train;

import ru.job4j.search.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionUsage {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        for (String string : collection) {
            System.out.println(string);
        }

        Collection<String> list = new ArrayList<>(collection);
        for (String string : list) {
            System.out.println(string);
        }

        list.remove("two");
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println("\n Вывод содержимого коллекции после удаления");
        System.out.println("Размер коллекции: " + list.size());
        System.out.println("Коллекция содержит элемент one: " + list.contains("one"));
        System.out.println("Коллекция пуста: " + list.isEmpty());
        System.out.println("Содержимое в виде массива: " + Arrays.toString(list.toArray()));

        Integer pop = 132;
        List test = new ArrayList<>();
        test.add("popopp");
        test.add(pop);

        System.out.println(test);

        List.of(1, 2, 3, 4, 5, 6);
    }
}