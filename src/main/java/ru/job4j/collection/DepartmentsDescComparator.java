package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] lft = left.split("/");
        String[] rght = right.split("/");
        int size = Math.min(lft.length, rght.length);
        int result = rght[0].compareTo(lft[0]);
        if (result == 0) {
            if (size > 1) {
                for (int index = 1; index < size; index++) {
                    if (lft[index].compareTo(rght[index]) != 0) {
                        return lft[index].compareTo(rght[index]);
                    }
                }
            }
            return left.compareTo(right);
        }
        return result;
    }
}