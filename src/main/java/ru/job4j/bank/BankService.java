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
        if (findByPassport(passport) != null) {
            users.remove(findByPassport(passport));
        }
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null && !users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
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
        Account foundByReq = null;
        if (findByPassport(passport) != null) {
            for (Account acc : users.get(findByPassport(passport))) {
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