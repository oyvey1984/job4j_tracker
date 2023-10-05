package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person per : persons) {
            if (per.getName().contains(key) || per.getSurname().contains(key)
                    || per.getPhone().contains(key) || per.getAddress().contains(key)) {
                result.add(per);
            }
        }
        return result;
    }
}