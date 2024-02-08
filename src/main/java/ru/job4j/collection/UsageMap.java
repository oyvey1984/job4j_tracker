package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> emailDataBase = new HashMap<>();
        emailDataBase.put("ayrat.tazetdinov@mail.ru", "Ayrat Tazetdinov");
        emailDataBase.put("oyvey@gmail.com", "Duhast Vaycheslavov");
        emailDataBase.put("a.pop@yandex.ru", "Ivan Petrov");
        emailDataBase.put("a.pop@yandex.ru", "Artur Ershov");
        for (String key : emailDataBase.keySet()) {
            System.out.println(emailDataBase.get(key));
        }
    }
}