package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - летает со скоростью 800 км/ч");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " - вмещает 600 пассажиров.");
    }
}