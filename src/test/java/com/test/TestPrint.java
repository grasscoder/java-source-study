package com.test;

import java.util.concurrent.atomic.AtomicBoolean;

/*
 * 交替打印输出1、2
 * */
public class TestPrint {
    static  boolean status = Boolean.TRUE;
    static final Object object = new Object();

    public static void main(String[] args) {
        Thread p1 = new Thread(()->{
            int i = 1;
            while (true) {
                synchronized (object) {
                    if (status) {//true
                        System.out.println("奇数: " + i);
                        i += 2;
                        status = false;
                        if(!status)
                            object.notifyAll();
                        try {
                            object.wait();//释放锁
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        object.notifyAll();
                    }
                    if(i > 100)
                        break;
                }
            }
        }, "奇数线程");
        Thread p2 = new Thread(() -> {
            int i = 2;
            while (true) {
                synchronized (object) {
                    if (!status) {//false
                        System.out.println("偶数: " + i);
                        i += 2;
                        status = true;
                        if(status)
                            object.notifyAll();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        object.notifyAll();
                    }
                    if(i > 100)
                        break;
                }
            }
        }, "偶数线程");
        p2.start();
        p1.start();
    }
}

class Print1 implements Runnable {

    private Object obj1;
    /*
     * sta == true 输出奇数；
     * */
    private boolean sta;

    public Print1(boolean status, Object obj) {
        this.sta = status;
        this.obj1 = obj;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            synchronized (obj1) {
                if (this.sta) {//true
                    System.out.println("奇数: " + i);
                    i += 2;
                    this.sta = false;
                    try {
                        obj1.wait();//释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    obj1.notifyAll();
                }
                if(i > 100)
                    break;
            }
        }
    }
}

class Print2 implements Runnable {

    private Object obj2;
    /*
     * sta == false 输出偶数；
     * */
    private boolean sta;

    public Print2(boolean status,  Object obj) {
        this.sta = status;
        this.obj2 = obj;
    }

    @Override
    public void run() {
        int i = 2;
        while (true) {
            synchronized (obj2) {
                if (!this.sta) {//false
                    System.out.println("偶数: " + i);
                    i += 2;
                    this.sta = false;
                    try {
                        obj2.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    obj2.notifyAll();
                }
                if(i > 100)
                    break;
            }
        }
    }
}