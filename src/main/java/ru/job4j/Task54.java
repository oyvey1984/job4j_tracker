package ru.job4j;

public class Task54 {
    public static void transform(int number) {
        int num1 = number / 100;
        int num2 = number / 10 % 10;
        int num3 = number % 10;
        if (number < 0) {
            if (number % 2 == 0) {
                if (num1 % 2 == 0) {
                    num1--;
                } else {
                    num1++;
                }
                if (num2 % 2 == 0) {
                    num2--;
                } else {
                    num2++;
                }
                if (num3 % 2 == 0) {
                    num3--;
                } else {
                    num3++;
                }
                System.out.println(num1 * 100 + num2 * 10 + num3);
            } else {
                if (num1 % 2 == 0) {
                    num1++;
                } else {
                    num1--;
                }
                if (num2 != 0) {
                    if (num2 % 2 == 0) {
                        num2++;
                    } else {
                        num2--;
                    }
                }
                if (num3 != 0 && num3 != -9) {
                    if (num3 % 2 == 0) {
                        num3++;
                    } else {
                        num3--;
                    }
                }
                System.out.println(num1 * 100 + num2 * 10 + num3);
            }
        } else {
            if (number % 2 == 0) {
                if (num1 % 2 == 0) {
                    num1++;
                } else {
                    num1--;
                }
                if (num2 % 2 == 0) {
                    num2++;
                } else {
                    num2--;
                }
                if (num3 % 2 == 0) {
                    num3++;
                } else {
                    num3--;
                }
                System.out.println(num1 * 100 + num2 * 10 + num3);
            } else {
                if (num1 != 9) {
                    if (num1 % 2 != 0) {
                        num1++;
                    }
                } else if (num1 % 2 == 0) {
                    num1--;
                }
                if (num2 != 9) {
                    if (num2 % 2 != 0) {
                        num2++;
                    }
                } else if (num2 % 2 == 0) {
                    num2--;
                }
                if (num3 != 9) {
                    if (num3 % 2 != 0) {
                        num3++;
                    }
                } else if (num3 % 2 == 0) {
                    num2--;
                }
                System.out.println(num1 * 100 + num2 * 10 + num3);
            }
        }
    }

    public static void main(String[] args) {
        transform(333);
    }
}