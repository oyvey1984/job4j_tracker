package ru.job4j.train.pattern.strategy;

public class Training implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}