package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime itemGetDateTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentItemGetDataTimeFormat = itemGetDateTime.format(formatter);
        System.out.println("Текущие дата и время из поля класса Item: " + currentItemGetDataTimeFormat);

        Item itemToString = new Item();
        System.out.println(itemToString);
    }
}