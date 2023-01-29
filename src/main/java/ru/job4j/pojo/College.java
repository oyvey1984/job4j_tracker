package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstNameLastNamePatronymic("Tazetdinov Ayrat Tazetdinov. ");
        student.setGroup("Genetics 161 group. ");
        student.setReceiptDate(LocalDate.of(2006, 8, 3));

        System.out.println(student.getFirstNameLastNamePatronymic() + student.getGroup() + student.getReceiptDate());
    }
}