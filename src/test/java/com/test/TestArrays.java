package com.test;

public class TestArrays {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};
        long t = System.currentTimeMillis();
        for (int i = 0; i < args.length; i++) {
            int a = arr[i];
            System.out.println(a);
        }
        System.out.println("时间差: "+(t - System.currentTimeMillis()));
        t = System.currentTimeMillis();
        for(int i = 0, j = arr.length - 1; i <= j; i++,j--){
            int a = arr[i];
            int b = arr[j];
            System.out.println(a+","+b);
        }
        System.out.println("时间差2: "+(System.currentTimeMillis()-t));
    }
}
