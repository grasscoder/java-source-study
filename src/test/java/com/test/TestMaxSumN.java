package com.test;

public class TestMaxSumN {
    /*
    * 连续子数组最大和
    * */
   public int maxSum(int[] arr){
       if(arr == null || arr.length == 0){
           return -101;
       }
       int sum = 0;
       int max = Integer.MIN_VALUE;
       for (int i = 0; i < arr.length; i++) {
           if(sum >= 0){
               sum += arr[i];
           }else{
               sum = arr[i];
           }
           max = Math.max(max, sum);
       }
       return max;
   }

   /*
   * 连续子数组最大乘积
   * */
    public int maxMulti(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int max  = Integer.MIN_VALUE;
        int imax = 1,imin = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                imax = imax ^ imin;
                imin = imax ^ imin;
                imax = imax ^ imin;
            }
            imax = Math.max(imax*arr[i], arr[i]);
            imin = Math.min(imin*arr[i], arr[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,-3,4,1,-2,-5,6,7};
        TestMaxSumN t = new TestMaxSumN();
        int s = t.maxSum(arr);
        System.out.println(s);
        int m = t.maxMulti(arr);
        System.out.println(m);
    }
}
