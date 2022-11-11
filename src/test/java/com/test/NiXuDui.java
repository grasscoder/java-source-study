package com.test;

import java.util.Arrays;

public class NiXuDui {
    static int res = 0;
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 6, 5};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
    }

    /*
    * 归并排序(mergeSort)，分治法(divide,merge)
    *  divide由递归mergeSort实现
    * */
    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        //分（用递归megerSort来实现）
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end ) {
        int[] tmpArr = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j])
                tmpArr[k++] = arr[i++];
            else {
                tmpArr[k++] = arr[j++];
                //res = (res + mid - i + 1) % 1000000007;
            }
        }
        while(i <= mid){
            tmpArr[k++] = arr[i++];
        }
        while(j <= end){
            tmpArr[k++] = arr[j++];
        }
        for(k = 0; k < tmpArr.length; k++){
            arr[start + k] = tmpArr[k];
        }
    }

}
