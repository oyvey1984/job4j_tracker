package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        String petr = "Petr";
        String ivan = "Ivan";
        int resultString = petr.compareTo(ivan);
        System.out.println(resultString);

        Integer first = 1;
        Integer second = 2;
        int result = first.compareTo(second);
        System.out.println(result);

        List<Integer> list2 = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list2);
        Collections.sort(list2, Collections.reverseOrder());
        System.out.println(list2);
    }
}