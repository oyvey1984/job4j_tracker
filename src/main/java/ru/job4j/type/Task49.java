package ru.job4j.type;

public class Task49 {
    public static void isPalindrome(int number) {
        String toString = Integer.toString(number);
        boolean palindrome = false;
        if (toString.length() % 2 == 0) {
            for (int index = 0; index < toString.length() / 2; index++) {
                if (toString.charAt(index) != toString.charAt(toString.length() - 1 - index)
                        && index != toString.length() - 2 - index) {
                    palindrome = false;
                    break;
                } else {
                    palindrome = true;
                }
            }
        } else {
            for (int index = 0; index < toString.length() / 2; index++) {
                if (toString.charAt(index) != toString.charAt(toString.length() - 1 - index)
                        && index != toString.length() - 2 - index) {
                    palindrome = false;
                    break;
                } else {
                    palindrome = true;
                }
            }
            if (toString.length() == 1) {
                palindrome = true;
            }
        }
        if (palindrome) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }

    public static void main(String[] args) {
        isPalindrome(3);
    }
}