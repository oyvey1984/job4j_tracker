package ru.job4j.io;

import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double r = input.nextDouble();
        double p = a * 4;
        double circumference = 2 * Math.PI * r;
        double areaOfCircle = Math.PI * Math.pow(r, 2);
        System.out.printf("%.1f\n", p);
        System.out.printf("%.1f\n", circumference);
        System.out.printf("%.1f\n", areaOfCircle);
    }
}