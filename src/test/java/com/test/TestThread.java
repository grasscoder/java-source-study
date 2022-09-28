package com.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestThread {
    public static volatile boolean f = false;

    public static void main(String[] args) throws InterruptedException {
//        Thread t =  new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println("" +i);
//            }
//        });
//        t.start();
//        t.join();
//        new Object().wait();
////        System.out.println( Thread.currentThread().getName() + " 结束");
//        Thread t  = new Thread(() -> {
//            System.out.println("开始。。。");
//            while(!f){
//
//            }
//            System.out.println("结束。。。");
//        });
//        t.start();
//        Thread.sleep(100);//main线程sleep,让当前线程睡眠
//
//        Thread t2 = new Thread(() ->{
//            System.out.println("修改全局变量前。。。");
//            f = true;
//            System.out.println("修改全局变量后。。。");
//        });
//        t2.start();
//        AtomicInteger i = new AtomicInteger(0);
//        while (true) {
//            Thread thread = new Thread(() -> {
//                try {
//                    i.getAndIncrement();
//                    Thread.sleep(8);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            thread.setName("test-test_" + i.get());
//            thread.start();
//        }
//
//        Scanner sc = new Scanner(System.in);
//        int ss = sc.nextInt();
//        int array[] = null;
//        sc.nextLine();
//        if (sc.hasNextLine()) {
//            String arr[] = sc.nextLine().replace("\\n", "").split(" ");
//            array = Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
//            System.out.println(Arrays.toString(array));

        Scanner sc = new Scanner(System.in);
        int[] vw = Arrays.stream(sc.nextLine().replace("\\n","").split(" ")).mapToInt(Integer::valueOf).toArray();

        int arrV[] = new int[vw[0]];
        int arrW[] = new int[vw[0]];
        int i = 0;
        while(i < vw[0] && sc.hasNextLine()){
            String[] line = sc.nextLine().replace("\\n","").split(" ");
            arrV[i] = Integer.valueOf(line[0]);
            arrW[i++] = Integer.valueOf(line[1]);
        }
    }
}
