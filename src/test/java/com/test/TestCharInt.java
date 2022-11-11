package com.test;

import java.util.Arrays;

public class TestCharInt {
    public static void main(String[] args) {
//        char a = 'a';
//        System.out.println(a);
//        char b = 97;
//        System.out.println(b);
//        char c = 97 - 32;
//        System.out.println(c);
        String s = "aab";
        // int ss = longestSubstring(s);
        //System.out.println(ss);
        int[] arr = {3,2,1,0,4};
        //System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));
        System.out.println(canJump(arr));


    }

    public static int longestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] num = s.toCharArray();
        int left = 0, right = 0;
        int[] arr = new int[128];
        Arrays.fill(arr, -1);
        int len = num.length;
        int max = 0;
        int tmpMax = 0;
        for (; right < len; right++) {
            char c = num[right];
            if (arr[c] >= 0) {
                max = getMax(getMax(tmpMax, right - left), max);
                left = right;
                tmpMax = 0;
            } else {
                tmpMax++;
                arr[c] = right + 1;
            }
        }
        return max > tmpMax ? max : tmpMax;

    }

    public static int test(String s) {
        int n = s.length();
        int result = 0;
        int[] arr = new int[128];
        for (int left = 0, right = 0; right < n; right++) {
            char c = s.charAt(right);
            left = getMax(left, arr[c]);
            result = getMax(result, right - left + 1);
            arr[c] = right + 1;
        }
        return result;
    }

    public static int getMax(int a, int b) {
        return a >= b ? a : b;
    }

    public static int[] quickSort(int[] nums, int start, int end) {
        if(start > end){
            return nums;
        }
        int i = start;
        int j = end;
        int povit = nums[j];
        while (i < j) {
            while (i < j && nums[i] <= povit) {
                i++;
            }
            nums[j] = nums[i];
            while (i < j && nums[j] > povit) {
                j--;
            }
            nums[i] = nums[j];
        }
        nums[i] = povit;
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
        return nums;
    }

    public static boolean canJump(int[] nums) {
        if(nums == null|| nums.length == 0)
            return false;
        if(nums.length == 1)
            return true;

        int maxValue = 0;
        for(int i = 0; i < nums.length; i++) {
            if(maxValue < i)
                return false;
            maxValue = maxValue > (i + nums[i]) ? maxValue : (i + nums[i]);
        }
        return maxValue >= nums.length - 1;
        //return canJump(nums, nums.length);

    }

}
