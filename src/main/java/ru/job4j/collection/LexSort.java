package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] lft = left.split("\\.");
        String[] rght = right.split("\\.");
        return Integer.compare(Integer.parseInt(lft[0]), Integer.parseInt(rght[0]));
    }
}