package com.test;

import java.util.concurrent.*;

public class TestExcutors {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(100);
        ThreadPoolExecutor executorService1 = new ThreadPoolExecutor(10,15,100L,
                TimeUnit.MILLISECONDS, queue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
//        for (int i = 0; i < 200; i++) {
//           executorService1.execute(() -> {
//                try {
//                    Thread.sleep(1L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                String printStr = "【thread-name:" + Thread.currentThread().getName() +",active线程数量："+ executorService1.getActiveCount() + "," +"】";
//                System.out.println(printStr);
//            });
//        }

//        System.out.println(Integer.SIZE);
//        System.out.println(-1 << (Integer.SIZE -3));
//        System.out.println(-1 << (Integer.SIZE -3));
//        System.out.println();

        int COUNT_BITS = Integer.SIZE -3;
        System.out.printf("RUNNING:%s\n" , Integer.toBinaryString( (1 << COUNT_BITS) - 1));
        System.out.printf("RUNNING:%032s\n" , Integer.toBinaryString( (1 << COUNT_BITS) - 1));
        System.out.printf("SHUTDOWN:%032s\n" , Integer.toBinaryString(0 << COUNT_BITS));
        System.out.printf("STOP:%032s\n" , Integer.toBinaryString((1 << COUNT_BITS)));
        System.out.printf("TIDYING:%032s\n" , Integer.toBinaryString(2 << COUNT_BITS));
        System.out.printf("TERMINATED:%032s\n", Integer.toBinaryString(3 << COUNT_BITS));
        System.out.printf("CAPACITY:%032s\n" , Integer.toBinaryString((1 << COUNT_BITS) - 1));
        System.out.println("&: " + ((-536870912)&536870911));

        System.out.println(-536870912 | 0);
        System.out.println(~3);

    }
}
