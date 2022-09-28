package com.test;

import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProduceAndComsumer {
    static final List<Integer> list = new ArrayList<>(30);

    public static void main(String[] args) {
        Thread t1 = new Thread(new ConsumerTest(list));
        Thread t2 = new Thread(new ProducerTest(list));
        t1.start();
        t2.start();
    }
}

class ProducerTest implements Runnable {
    private List list;

    public ProducerTest(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (list) {
                list.notifyAll();
                if (list.size() < 20) {
                    System.out.println("produce : " + i);
                    list.add(i++);
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if(i > 100)
                    break;
            }
        }

    }
}

class ConsumerTest implements Runnable {
    private List list;

    public ConsumerTest(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (list) {
                list.notifyAll();
                if (list.size() > 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        System.out.println("consume : " + it.next());
                        it.remove();
                    }
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if(i > 100)
                    break;
            }
        }

    }
}
