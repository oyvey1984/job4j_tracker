package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        String single = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(single);
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
