package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox gena = new Jukebox();
        int song = 3;
        gena.music(song);
        song = 2;
        gena.music(song);
        song = 1;
        gena.music(song);
    }
}
