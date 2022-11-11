package com.test;

public class TestSearch {
    public static void main(String[] args) {
        int[] arr = {3, 1};
        int end = arr.length - 1;
        System.out.println(search(arr,3));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int j = 0;
        while (j + 1 < nums.length && nums[j] < nums[j + 1]) {
            j++;
        }
        if (j == nums.length - 1) {
            return find(nums, 0, nums.length - 1, target);
        }
        int a = find(nums, 0, j, target);
        return a == -1 ? find(nums, j + 1, nums.length - 1, target) : a;

    }

    public static int find(int[] nums, int start, int end, int target) {
        if (start < 0)
            start = 0;
        if (end > nums.length - 1)
            end = nums.length - 1;
        if (start > end)
            return -1;

        int i = start;
        int j = end;
        int mid = (i + j) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return find(nums, mid + 1, end, target);
        else
            return find(nums, start, mid - 1, target);
    }
}
