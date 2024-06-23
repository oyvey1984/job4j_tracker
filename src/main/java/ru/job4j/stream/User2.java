package ru.job4j.stream;

public class User2 {
    private String name;
    private String surname;
    private byte age;
    private String login;
    private String password;
    private boolean activated;
    private String gender;

    public User2() {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
        this.activated = activated;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User2{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", activated=" + activated
                + ", gender='" + gender + '\''
                + '}';
    }

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String login;
        private String password;
        private boolean activated;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        User2 build() {
            User2 user2 = new User2();
            user2.name = name;
            user2.surname = surname;
            user2.age = age;
            user2.login = login;
            user2.password = password;
            user2.activated = activated;
            user2.gender = gender;
            return user2;
        }
    }

    public static void main(String[] args) {
        User2 user2 = new Builder()
                .buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 32)
                .buildLogin("login")
                .buildPassword("password")
                .buildActivated(true)
                .buildGender("male")
                .build();
        System.out.println(user2);
    }
}