package ru.job4j.train.pattern.decorator;

public class JavaDeveloper implements Developer {
    @Override
    public String makejob() {
        return "Write Java code.";
    }
}