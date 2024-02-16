package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User foundUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                foundUser = user;
                break;
            }
        }
        return foundUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account foundByReq = null;
        if (user != null) {
            for (Account acc : users.get(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    foundByReq = acc;
                    break;
                }
            }
        }
        return foundByReq;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account foundSource = findByRequisite(sourcePassport, sourceRequisite);
        Account foundDestination = findByRequisite(destinationPassport, destinationRequisite);
        if (foundSource != null && foundDestination != null) {
            if (foundSource.getBalance() >= amount) {
                foundDestination.setBalance(foundDestination.getBalance() + amount);
                foundSource.setBalance(foundSource.getBalance() - amount);
                result = true;
            }
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
