package com.test;

import java.util.Arrays;

public class TestSearchStartEnd {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        //System.out.println(Arrays.toString(searchRange(arr, 6)));
        String a = "asdaddsaa";
        String b = "saa";
        System.out.println(strStr(a, b));

    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        if (nums.length == 1 && nums[0] == target)
            return new int[]{0, 0};
        else if (nums.length == 1 && nums[0] != target) {
            return new int[]{-1, -1};
        }
        int index = find(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        //左边界
        int left = index - 1;
        while (left >= 0 && nums[left] == nums[index]) {
            left--;
        }
        int right = index + 1;
        while (right <= nums.length - 1 && nums[right] == nums[index]) {
            right++;
        }
        return new int[]{++left, ++right};

    }

    public static int find(int[] nums, int start, int end, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (start < 0)
            start = 0;
        if (end > nums.length - 1)
            end = nums.length - 1;
        if (start > end)
            return -1;
        int i = start;
        int j = end;
        int mid = (i + j) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return find(nums, mid + 1, end, target);
        } else {
            return find(nums, start, mid - 1, target);
        }
    }
    public static int strStr(String haystack, String needle){
         return haystack.indexOf(needle);
        //haystack.lastIndexOf(needle);
    }
}
