package ru.job4j.train.pattern.decorator;

public class DeveloperDecorator implements Developer {

    Developer developer;

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makejob() {
        return developer.makejob();
    }
}