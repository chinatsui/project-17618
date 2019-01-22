package me.chinatsui.java.concurrency;

import me.chinatsui.java.commons.Account;
import me.chinatsui.java.commons.ThreadUtils;

public class DeadLockSimulation {

    private static final DeadLockSimulation instance = new DeadLockSimulation();

    private DeadLockSimulation() {
    }

    public static void main(String[] args) {
        instance.simulateDeadLock();
    }

    public void simulateDeadLock() {
        Account acc1 = new Account("acc1", 102.3f);
        Account acc2 = new Account("acc2", 120.0f);

        new Thread(() -> transferMoneyWithSync(acc1, acc2, 23.3f)).start();
        new Thread(() -> transferMoneyWithSync(acc2, acc1, 23.3f)).start();
    }

    private void transferMoneyWithSync(Account src, Account dst, float amount) {
        String srcName = src.getName();
        String dstName = dst.getName();

        System.out.println(String.format(
                "%s: Start transferring dollars from %s to %s...",
                Thread.currentThread().getName(),
                srcName,
                dstName));

        synchronized (src) {
            ThreadUtils.sleep(100);
            synchronized (dst) {
                if (src.getBalance() > amount) {
                    src.debit(amount);
                    dst.credit(amount);
                    System.out.println(
                            String.format("Finished %s dollars transferred from %s to %s.",
                                    amount,
                                    srcName,
                                    dstName));
                } else {
                    throw new RuntimeException("Insufficient Amount Exception.");
                }
            }
        }
    }
}
