package me.chinatsui.java.commons;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String name;
    private float balance;
    private final ReentrantLock lock = new ReentrantLock();

    public Account(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    public void debit(float amount) {
        balance -= amount;
    }

    public void credit(float amount) {
        balance += amount;
    }

    public String getName() {
        return name;
    }

    public float getBalance() {
        return balance;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
