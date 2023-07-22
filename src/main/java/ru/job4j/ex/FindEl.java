package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
            }
            if (!value[index].equals(key)) {
                throw new ElementNotFoundException("Element not found");
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] task = {"Task ZeroPointFour", "Test"};
            indexOf(task, "Ex");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}