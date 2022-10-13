package com.test;

import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        int[] arr = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        System.out.println(threeSumClosest(arr, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l = nums.length - 1;
        int minAbs = 10001;
        int sum = 0;
        for (int i = 0; i <= l; i++) {
            int j = 0;
            if (j == i && j < l) {
                j++;
            }
            int k = l;
            while (j < k) {
                int tmpPlus = nums[i] + nums[j] + nums[k];
                int t = target - tmpPlus;
                //int minAbs = Math.min(minAbs, Math.abs(t));
                if (Math.abs(t) <= minAbs) {
                    minAbs = Math.abs(t);
                    sum = tmpPlus;
                }
                k--;
            }
        }
        return sum;
    }
}
