package com.test;

public class TestOnlyNotify {
    private static final Object obj =  new Object();
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread(obj));
        t.start();
    }
}

class MyThread implements Runnable{
    private Object obj;
    public MyThread(Object obj){
        this.obj = obj;
    }
    @Override
    public void run() {
            obj.notify();
    }
}
