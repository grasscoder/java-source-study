package com.test;

import java.util.ArrayList;
import java.util.concurrent.locks.LockSupport;

/*
 * 交替打印ABCABC......打印100个字符
 * */
public class TestPrintABC {
    static int count = 0;
    static final Object object = new Object();
    static final String A = "A";
    static final String B = "B";
    static final String C = "C";
    static int flag = 0;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (true) {
                synchronized (object) {
                    object.notifyAll();
                    if (count < 100 && flag == 0) {
                        System.out.print(A);
                        count++;
                        flag = count % 3;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        Thread b = new Thread(() -> {
            while (true) {
                synchronized (object) {
                    object.notifyAll();
                    if (count < 100 && flag == 1) {
                        System.out.print(B);
                        count++;
                        flag = count % 3;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        Thread c = new Thread(() -> {
            while (true) {
                synchronized (object) {
                    object.notifyAll();
                    if (count < 100 && flag == 2) {
                        System.out.print(C);
                        count++;
                        flag = count % 3;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }
}
