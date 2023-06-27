package ru.job4j.poly;

public interface Transport {

    void drive();

    void passengers(int numberOfPassengers);

    default int refill(int liters) {
        return liters * 50;
    }
}