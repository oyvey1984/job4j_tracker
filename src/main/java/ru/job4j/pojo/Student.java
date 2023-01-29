package ru.job4j.pojo;

import java.time.LocalDate;

public class Student {
    private String firstNameLastNamePatronymic;
    private String group;
    private LocalDate receiptDate;

    public String getFirstNameLastNamePatronymic() {
        return firstNameLastNamePatronymic;
    }

    public void setFirstNameLastNamePatronymic(String firstNameLastNamePatronymic) {
        this.firstNameLastNamePatronymic = firstNameLastNamePatronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }
}