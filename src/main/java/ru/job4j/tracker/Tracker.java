package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int length = 0;
        for (int index = 0; index < size; index++) {
            Item rtr = items[index];
            if (rtr.getName().equals(key)) {
                rsl[length] = rtr;
                length++;
            }
        }
        return Arrays.copyOf(rsl, length);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rtr = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            item.setId(id);
            rtr = true;
        }
        return  rtr;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            int start =  index + 1;
            int length = size - index - 1;
            System.arraycopy(items, start, items, index, length);
            items[size - 1] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }
}