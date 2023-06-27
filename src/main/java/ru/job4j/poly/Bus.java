package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Едем в Грузию.");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("1 водитель и 2 пассажира.");
    }

    @Override
    public int refill(int liters) {
        return Transport.super.refill(55);
    }
}