package ru.job4j.train.pattern.decorator;

public class Goal {
    public static void main(String[] args) {
        Developer developer = new SeniorJavaDeveloper(new JavaDeveloper());
        System.out.println(developer.makejob());
    }
}