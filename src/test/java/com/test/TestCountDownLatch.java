package com.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCountDownLatch {
    public static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, () -> {
            System.out.println(Thread.currentThread().getName() + "线程执行了这个runnable实例");
        });
        new Thread(()->{
            try {
                Thread.sleep(100L);
                cb.await();
                i.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"冲过栅栏" + i.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        },"Thread-1").start();
        new Thread(()->{
            try {
                Thread.sleep(100L);
                cb.await();
                i.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"冲过栅栏" + i.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        },"Thread-2").start();
        new Thread(()->{
            try {
                Thread.sleep(100L);
                cb.await();
                i.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"冲过栅栏" + i.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        },"Thread-3").start();
        new Thread(()->{
            try {
                Thread.sleep(100L);
                cb.await();
                i.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"冲过栅栏" + i.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        },"Thread-4").start();
        new Thread(()->{
            try {
                Thread.sleep(100L);
                cb.await();
                i.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"冲过栅栏" + i.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        },"Thread-5").start();
        new Thread(()->{
            try {
                Thread.sleep(100L);
                cb.await();
                i.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"冲过栅栏" + i.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        },"Thread-6").start();

    }
}
