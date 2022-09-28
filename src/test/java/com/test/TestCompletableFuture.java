package com.test;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            SmallTools.sleep(200L);
//            System.out.println("厨师炒菜");
//            return "炒菜";
//        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {
//            SmallTools.sleep(100L);
//            return dish + ",米饭";
//        }));
//        System.out.println(completableFuture.join());
//
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            SmallTools.printTimeAndThread("厨师开始炒菜");
//            SmallTools.sleep(100);
//            SmallTools.printTimeAndThread("厨师炒完菜了");
//            return "番茄鸡蛋";
//        }).thenCombine(CompletableFuture.supplyAsync(()->{
//            SmallTools.printTimeAndThread("服务员开始做饭");
//            SmallTools.sleep(150);
//            SmallTools.printTimeAndThread("服务员做完饭");
//            return "米饭";
//        }),(dish,rice)->{
//            return dish + "," + rice;
//        });
//        SmallTools.printTimeAndThread("开始吃饭了:" + completableFuture.join());

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            SmallTools.sleep(100);
//            return "700路公交车";
//        }).applyToEither(CompletableFuture.supplyAsync(()->{
//            SmallTools.sleep(150);
//            return "800路公交车";
//        }),result -> {
//            if(result.startsWith("700")){
//                throw new RuntimeException("");
//            }
//            return result;
//        }).exceptionally(e -> {
//            return "异常了，回不去了";
//        });
//        SmallTools.printTimeAndThread(completableFuture.join() +" 来了");
        CompletableFuture<Map<Integer,Integer>> completableFuture = CompletableFuture.supplyAsync(() -> {
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < 500; i++) {
                map.put(i, i);
            }
            return new ArrayList();
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 500; i < 510; i++) {
                map.put(i, i);
            }
            return map;
        }), (m1, m2) -> {
            m2 = new HashMap<>(m2);

            return m2;
        });
        Map<Integer,Integer>  mmap = completableFuture.join();
        mmap.entrySet().stream().forEach(entry ->{
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }
}

class SmallTools {
    public static void sleep(long msecond){
        try {
            Thread.sleep(msecond);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }
     public static void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(Thread.currentThread().getName())
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(tag)
                .toString();
         System.out.println(result);
     }

}
