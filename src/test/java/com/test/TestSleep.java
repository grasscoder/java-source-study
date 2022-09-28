package com.test;

public class TestSleep {
    public static void main(String[] args) {
         Thread t = new Thread(new ThreadTest());
         t.start();
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            System.out.println("啥样他:"+e.getMessage());
            throw new RuntimeException(e);
        }
        /*Thread.currentThread();*/

        System.out.println("当前线程："+Thread.currentThread().getName());
        t.interrupt();
        t.yield();
    }
}

class ThreadTest extends Thread {
    public void run(){
        try {
            Thread.sleep(1000*60*60*24);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());;
            System.out.println(e.getMessage());;
        }
    }
}