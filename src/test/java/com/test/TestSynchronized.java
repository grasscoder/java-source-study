package com.test;

public class TestSynchronized {
    Object o = new Object();
    public synchronized int getInt() {
        return 0;
    }

    public synchronized static int getInt2() {
        return 2;
    }
    public int getInt3() {
        synchronized (o){
            return 2;
        }
    }
    public static void main(String[] args) {

    }
}
