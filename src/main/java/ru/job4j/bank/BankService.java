package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает хранение и добавление пользователей в банковскую систему,
 * а также их счетов.
 * @author Ayrat Tazetdinov
 * @version 1.0
 */

public class BankService {

    /**
     * Пользователи и привязанные к ним счета хранятся в коллекции типа HashMap.
     * Счета пользователя хранятся в отдельной коллекции типа List.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в коллекцию users, если его в ней нет,
     * а также создаёт пользователю коллекцию List для его счетов.
     * @param user пользователей, который добавляется в коллекцию users.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из коллекции users.
     * @param passport паспортные данные, по которым пользователь находится в коллекции.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет новый счёт пользователю
     * @param passport паспортные данные, по которым пользователь находится в коллекции.
     * @param account новый счёт, который добавляется к пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Ищет пользователя по паспортным данным.
     * @param passport паспортные данные, по которым пользователь находится в коллекции.
     * @return возвращает найденного пользователя или null, если пользователь не найден.
     */
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

    /**
     * Ищет счёт пользователя по реквизитам.
     * @param passport паспортные данные, по которым пользователь находится в коллекции.
     * @param requisite реквизиты счёта, по которым ищется счёт пользователя.
     * @return возвращает найденный счёт пользователя или null, если счёт не найден.
     */
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

    /**
     * Перечисляет деньги с одного счёта на другой.
     * @param sourcePassport Пользователь, с чьего счёта будет перевод.
     * @param sourceRequisite Счёт пользователя, с которого будет перевод.
     * @param destinationPassport Пользователь, на счёт которого будет перевод.
     * @param destinationRequisite Счёт пользователя, на которй будет перевод.
     * @param amount Сумма перевода
     * @return Возвращает true если перевод успешен. Возвращает false, если счёт не найден
     * или не хватает денег на счёте sourcePassport (с которого переводят).
     */
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
