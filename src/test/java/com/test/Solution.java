package com.test;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 1};
        int[] brr = {1, 1, 5};
        int[] crr = {0, 0, 4, 2, 1, 0};
        System.out.println(Arrays.toString(change(crr)));
    }

    public static int[] change(int[] nums) {
        //输入[2,3,5,4,1]   输出[2,4,1,3,5]
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int e = nums.length - 1;
        int s = 0;
        while (e >= 1 && nums[e] <= nums[e - 1]) {
            e--;
        }
        if (e == nums.length - 1) {
            int tmp = nums[e];
            nums[e] = nums[e - 1];
            nums[e - 1] = tmp;
            return nums;
        }
        if (e == 0) {//没有比它大的
            for (int i = 0, j = nums.length - 1; i < j; i++) {
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j--];
            }
            return nums;
        }
        int low_1 = nums[e - 1];
        int minus = 10000;
        int lowIndex = -1;
        int tmp = 0;
        for (int i = e; (tmp = i) < nums.length; i++) {
            if (low_1 >= nums[i]) {
                continue;
            }
            int tmpLow = Math.abs(nums[i] - low_1);
            if (tmpLow < minus) {
                minus = tmpLow;
                lowIndex = i;
            }
        }
        nums[e - 1] ^= nums[lowIndex];
        nums[lowIndex] ^= nums[e - 1];
        nums[e - 1] ^= nums[lowIndex];
        quickSort(nums, e, nums.length - 1);
        return nums;
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return arr;
        }
        int i = start;
        int j = end;
        int povit = arr[j];
        while (i < j) {
            while (i < j && arr[i] <= povit) {
                i++;
            }
            arr[j] = arr[i];
            while (i < j && arr[j] > povit) {
                j--;
            }
            arr[i] = arr[j];
        }
        arr[i] = povit;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
        return arr;
    }
}
