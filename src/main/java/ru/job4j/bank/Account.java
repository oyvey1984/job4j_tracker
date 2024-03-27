package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счёта.
 * Эта модель содержит поля: баланс и реквизиты.
 * @author Ayrat Tazetdinov
 * @version 1.0
 */

public class Account {
    /**
     * Поле хранит реквизиты банковского счёта.
     */
    private String requisite;

    /**
     * Поле хранит баланс банковского счёта.
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}