package ru.job4j.oop;

public class FootballPlayer extends Sportsman {

    @Override
    void run() {
        System.out.println("Средня скорость бега");
    }

    public void footKick() {
        System.out.println("Удар ногой по мячу");
    }
}
