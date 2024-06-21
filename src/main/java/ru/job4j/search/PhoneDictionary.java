package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = pers -> (pers.getName().contains(key));
        Predicate<Person> surname = pers -> (pers.getSurname().contains(key));
        Predicate<Person> phone = pers -> (pers.getPhone().contains(key));
        Predicate<Person> address = pers -> (pers.getAddress().contains(key));
        Predicate<Person> combine = name.or(surname).or(phone).or(address);

        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}