package com.test;

import java.util.ArrayList;
import java.util.List;

public class TestThreadLocal {
     static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> {
         return "";
     });

    public static void main(String[] args) throws InterruptedException {
//        System.out.println();
//        threadLocal.set("AAA");
//        System.out.println(threadLocal.get());
//        System.out.println(threadLocal.get());
//        threadLocal.set("BBB");
//        System.out.println(threadLocal.get());
//        threadLocal.remove();
        Thread t = new Thread(() -> {
            System.out.println("线程运行");
        });
        t.start();
        System.out.println(t.getState());
        Thread.sleep(2000);
        System.out.println(t.getState());
        t.isInterrupted();
        t.start();
    }
}
