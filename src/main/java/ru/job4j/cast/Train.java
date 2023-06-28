package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - едет только по рельсам с максимальной скоростью 200 км/ч.");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " - вмещает до 36 пассажиров в купейном вагоне.");
    }
}