package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rtr = null;
        for (User us : users) {
            if (login.equals(us.getUsername())) {
                rtr = us;
                break;
            }
        }
        if (rtr == null) {
            throw new UserNotFoundException("User not found");
        }
        return rtr;
    }

    public static boolean validate(User user) throws UserInvalidException {
        String lengthUserName = user.getUsername();
        int len = lengthUserName.length();
        if (!user.isValid() || len < 3) {
            throw new UserInvalidException("This user hasn't an access");
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true),
                    new User("Ayrat", true),
                    new User("Aleksandr", false)
            };
            User user = findUser(users, "Petr Arsentev");
            assert user != null;
            validate(users[2]);
        }  catch (UserInvalidException ui) {
            ui.printStackTrace();
        }  catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}