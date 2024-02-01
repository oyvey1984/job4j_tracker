package ru.job4j.train.pattern.factory;

public class JavaDeveloperFactory implements DeveloperFactory {

    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}