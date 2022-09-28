package com.test;

public class TestPrintDaemon {
    private static final Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i = 1;
            while(true) {
                synchronized (object){
                    object.notifyAll();//拿到锁就唤醒所有等待object监视器锁的线程
                    System.out.println("奇数: " + i);
                    i += 2;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    if(i > 100)
                        break;
                }
            }
        },"奇数线程");
        Thread t2 = new Thread(() -> {
            int i = 2;
            while(true) {
                synchronized (object){
                    object.notifyAll();//拿到锁就唤醒所有等待object的线程
                    System.out.println("偶数: " + i);
                    i += 2;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    if(i > 100)
                        break;
                }

            }
        },"偶数线程");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        //t1.join();
        //Thread.sleep(100);
        t2.start();
//        t1.join();
//        t2.join();
    }
}

