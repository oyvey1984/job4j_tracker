package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public HashSet extractNumber(List<Task> goal) {
        HashSet<String> numbers = new HashSet<>();
        for (Task task : goal) {
            numbers.add(task.getNumber());
        }
        return numbers;
    }
}
