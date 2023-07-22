package ru.job4j.type;

public class Task34 {
    public static void evenAmount(int number) {
        int num1, num2, num3, num4, counter = 0;
        num1 = number / 1000;
        num2 = number % 1000 / 100;
        num3 = number % 1000 % 100 / 10;
        num4 = number % 1000 % 100 % 10;
        int[] qwerty = {num1, num2, num3, num4};
        for (int qq : qwerty) {
            if (qq % 2 == 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}