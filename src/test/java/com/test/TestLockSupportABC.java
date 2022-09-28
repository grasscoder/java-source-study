package com.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockSupportABC {
    static int count = 0;
    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (true) {
                lock.lock();
                if(count < 100) {
                    System.out.println("A");
                    count++;
                    conditionB.signal();
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                lock.unlock();
                if(count == 100)
                    break;
            }
        });
        Thread b = new Thread(() -> {
            while (true) {
                lock.lock();
                if(count < 100) {
                    System.out.println("B");
                    count++;
                    conditionC.signal();
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                lock.unlock();
                if(count == 100)
                    break;
            }
        });
        Thread c = new Thread(() -> {
            while (true) {
                lock.lock();
                if(count < 100) {
                    System.out.println("C");
                    count++;
                    conditionA.signal();
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                lock.unlock();
                if(count == 100)
                    break;
            }
        });
        a.start();
        b.start();
        c.start();

    }
}
