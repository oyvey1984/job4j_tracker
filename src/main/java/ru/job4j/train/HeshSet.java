package ru.job4j.train;

import java.util.HashSet;
import java.util.Set;

public class HeshSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Table");
        set.add("Music");
        set.add("Pop");

        System.out.println(set);

        set.remove("Pop");
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        for (String str : set) {
            System.out.println(str);
        }
    }
}
