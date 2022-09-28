//package com.test;
//
//import java.util.concurrent.Delayed;
//import java.util.concurrent.TimeUnit;
//
//public class TestDelayedQueue {
//    final long startTime = System.currentTimeMillis();
//    public record DelayedEvent(long startTime, String msg) implements Delayed {
//
//        public long getDelay(TimeUnit unit) {
//            long diff = startTime - System.currentTimeMillis();
//            return unit.convert(diff, TimeUnit.MILLISECONDS);
//        }
//
//        public int compareTo(Delayed o) {
//            return (int) (this.startTime - ((DelayedEvent) o).startTime);
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//
//    }
//}
