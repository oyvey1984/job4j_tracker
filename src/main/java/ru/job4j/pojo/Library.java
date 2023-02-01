package ru.job4j.pojo;

import java.util.Objects;

public class Library {
    public static void main(String[] args) {
        Book braveNewWorld = new Book("Brave New World", 350);
        Book nineteenEightyFour = new Book("Nineteen Eighty-Four", 319);
        Book animalFarm = new Book("Animal Farm", 117);
        Book cleanCode = new Book("Clean code", 272);
        Book[] books = new Book[4];
        books[0] = braveNewWorld;
        books[1] = nineteenEightyFour;
        books[2] = animalFarm;
        books[3] = cleanCode;

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }

        System.out.println("Replace index 0 and index 3.");
        books[0] = cleanCode;
        books[3] = braveNewWorld;

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }

        System.out.println("Shown only book Clean code");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (Objects.equals(bk.getName(), "Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
    }
}
