package com.test;

public class TestFind {
    public static int closeIndex = 10001;
    public static int closeIndex1 = 10001;
    public static int closeIndex2 = 10001;
    public static int closeVal = 10000000;

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(arr, target));

    }

    public static int searchInsert(int[] nums, int target) {
        int a = find(nums, 0, nums.length - 1, target);
        if (a == -1) {
            System.out.println("closeIndex = " + closeIndex);
            while(closeIndex < nums.length && nums[closeIndex] < target)
                closeIndex++;
            return closeIndex;
        }
        return a;

    }

    public static int find(int[] nums, int start, int end, int target) {
        if (start < 0)
            start = 0;
        if (end > nums.length - 1) {
            end = nums.length - 1;
        }
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target) {
            if (Math.abs(nums[mid] - target) < closeVal) {
                closeVal = Math.abs(nums[mid] - target);
                closeIndex = mid;
            }
            return find(nums, mid + 1, end, target);
        } else {
            if (Math.abs(nums[mid] - target) < closeVal) {
                closeVal = Math.abs(nums[mid] - target);
                closeIndex = mid;
            }
            return find(nums, start, mid - 1, target);
        }
    }
}
