package me.chinatsui.java.concurrency;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;

import me.chinatsui.java.commons.Account;
import static me.chinatsui.java.commons.ThreadUtils.sleep;

/**
 * Use TimedLock to address dead lock issue.
 */
public class TimedLockAcquisition {

    private static final TimedLockAcquisition INSTANCE = new TimedLockAcquisition();

    private int timeSpan = 3;

    private TimedLockAcquisition() {
    }

    public static void main(String[] args) {
        INSTANCE.simulateTimedLockAcquisition();
    }

    public void simulateTimedLockAcquisition() {
        Account acc1 = new Account("acc1", 102.3f);
        Account acc2 = new Account("acc2", 120.0f);

        new Thread(() -> transferMoneyWithTryLock(acc1, acc2, 23.3f)).start();
        new Thread(() -> transferMoneyWithTryLock(acc2, acc1, 23.3f)).start();
    }

    private void transferMoneyWithTryLock(Account src, Account dst, float amount) {
        System.out.println(String.format("Start transferring money from %s to %s", src.getName(), dst.getName()));

        Lock lock1 = src.getLock();
        Lock lock2 = dst.getLock();

        Instant start = Instant.now();
        while (true) {
            if (lock1.tryLock()) {
                try {
                    sleep(ThreadLocalRandom.current().nextInt(200));
                    if (lock2.tryLock()) {
                        try {
                            if (src.getBalance() > amount) {
                                src.debit(amount);
                                dst.credit(amount);
                                System.out.println(
                                        String.format("Finished transfer money from %s to %s, amount: %s",
                                                src.getName(),
                                                dst.getName(),
                                                amount)
                                );
                                break;
                            } else {
                                throw new RuntimeException("Insufficient Amount Exception.");
                            }
                        } finally {
                            lock2.unlock();
                        }
                    }
                } finally {
                    lock1.unlock();
                }
            }

            Instant now = Instant.now();
            if (start.until(now, ChronoUnit.SECONDS) >= timeSpan) {
                System.out.println(String.format(
                        "Pause one simultaneous transaction, src: %s, dst: %s, so another one could complete soon",
                        src.getName(),
                        dst.getName()));
                sleep(500);
                start = Instant.now();
            }
        }
    }
}
