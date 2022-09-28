package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestProducerAndConsumer {
    static List list = new ArrayList(20);
    public static void main(String[] args) {
        Thread t1 = new Thread(new Producer01(list));
        Thread t2 = new Thread(new Consumer01(list));
        t1.start();
        t2.start();
    }
}
class Producer01 implements Runnable {

    private List list;

    public Producer01(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            int i = 0;
            while(true){
                if(list.size() >= 10){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Produce : " + i);
                list.add(i++);
                if(list.size() >= 10) {
                    list.notifyAll();
                }
            }
        }

    }
}

class Consumer01 implements Runnable {
    private List list;

    public Consumer01(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while(true) {
                if(list.size() <= 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Iterator it =list.iterator();
                while(it.hasNext()) {
                    System.out.println("Consume : " + it.next());
                    it.remove();
                }
                list.notifyAll();
            }
        }

    }
}
