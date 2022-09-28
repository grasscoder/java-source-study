package com.test;

public class TestInterrupt {
    public static Object obj = new Object();
    public static void main(String[] args) {
//        Thread t = new Thread(new TestRunnable());
//        t.start();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        t.interrupt();

        Thread t2 = new Thread(new InterruptTest(obj));
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());;
        }
        t2.interrupt();
    }
}
class TestRunnable implements  Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());;
        }
    }
}

class InterruptTest implements Runnable {

    private Object obj;

    public InterruptTest(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                while(true){
                    obj.wait();
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println(Thread.currentThread().getName() + " has been interrupted.");
                        break;
                    }
                }
            } catch (InterruptedException e) {
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName() + " has been interrupted2.");
                }
                System.out.println("interrupt异常处理：" + e.getMessage());
            }
        }
    }
}