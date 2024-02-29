package ru.job4j.collection;

import java.util.Arrays;

public class BubbleSorter {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //внутренний цикл -за перебор элементов в одном проходе
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    //переменная temp отвечает за обмен значений
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 4, 1, 2, 9, 3, 5, 6};
        sort(arr);

    }

    private void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}