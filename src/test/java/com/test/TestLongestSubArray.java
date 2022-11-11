package com.test;

import java.util.Arrays;

public class TestLongestSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 5, 2};
        System.out.println(maxLength(arr));
    }

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1)
            return 1;

        // if(arr.length == 2){
        //     return arr[0] == arr[1] ? 1 : 2;
        // }

        int[] nums = new int[100000];
        Arrays.fill(nums, -1);
        int res = 0;
        int[] rt = new int[]{-1, -1};
        for (int i = 0, j = 0; j < arr.length; ) {
            if (nums[arr[j]] == -1)
                nums[arr[j]] = j++;
            else {
                nums[arr[i++]] = -1;
            }
            if (res < j - i) {
                res = j - i;
                rt[0] = i;
                rt[1] = j;
            }
        }
        System.out.println(rt[0] + "  ---  " + (rt[1] - 1));
        return res;
    }
}
