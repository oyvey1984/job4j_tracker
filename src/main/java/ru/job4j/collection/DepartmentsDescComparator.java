package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] lft = left.split("/");
        String[] rght = right.split("/");
        int result = rght[0].compareTo(lft[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}