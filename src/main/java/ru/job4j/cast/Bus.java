package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        int speed = 90;
        System.out.println(getClass().getSimpleName() + " - едет со скоростью " + speed + " км/ч.");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " - вмещает до 30 пассажиров.");
    }
}