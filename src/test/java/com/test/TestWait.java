package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * wait()/notify/notifyAll()实现生产者消费者
 * */
public class TestWait {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(30);
        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));
        t1.setName("Producer Thread");
        t2.setName("Consumer Thread");
        t1.start();
        t2.start();
    }
}

class Producer implements Runnable {

    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            int i = 0;
            while (true) {
                if (list.size() >= 20) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("消费者代码还会继续执行么？" + list.size());
                } else {
                    System.out.println("++Add Array element : " + i);
                    list.add(i++);
                    if (list.size() >= 20) {
                        System.out.println("product notifyAll");
                        list.notifyAll();
                    }
                }
            }
        }

    }
}

class Consumer implements Runnable {

    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() >= 20) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        System.out.println("--Remove Array element : " + it.next());
                        it.remove();
                    }
                    list.notifyAll();
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
        }

    }
}

