package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int e) {
        return e - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int all) {
        return sum(all) + multiply(all) + minus(all) + divide(all);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int res = minus(15);
        System.out.println(res);
        int rslt = calculator.divide(30);
        System.out.println(rslt);
        int finish = calculator.sumAllOperation(100);
        System.out.println(finish);
    }
}