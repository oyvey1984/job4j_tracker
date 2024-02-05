package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer lastCustomer;
        String name = null;
        for (int i = 1; i <= count; i++) {
            lastCustomer = queue.poll();
            assert lastCustomer != null;
            name = lastCustomer.name();
        }
        return name;
    }

    public String getFirstUpsetCustomer() {
        Customer firstUpsetCustomer;
        String name = null;
        for (int i = 1; i <= count; i++) {
            queue.poll();
            firstUpsetCustomer = queue.element();
            name = firstUpsetCustomer.name();
        }
        return name;
    }
}