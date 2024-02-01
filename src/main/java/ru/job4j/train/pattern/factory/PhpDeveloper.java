package ru.job4j.train.pattern.factory;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes PHP code...");
    }
}