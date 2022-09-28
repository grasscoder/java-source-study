package com.test;

public class TestFindPeek {
    public static int find(int[] nums, int begin, int end) {
        if(begin > end){
            return -1;
        }
        int mid = (begin + end) / 2;
        if(begin + 1 <= end && nums[begin] > nums[begin + 1]){
            return begin;
        }
        if(begin <= end-1 && nums[end] > nums[end - 1]){
            return end;
        }
        if(mid > begin && nums[mid] > nums[mid-1] && mid < end &&  nums[mid] > nums[mid+1]) {
            return mid;
        } else if(mid > begin && nums[mid] < nums[mid-1] && mid < end &&  nums[mid] < nums[mid+1]) {
            return find(nums, begin ,mid -1);//向左找
        } else if(mid > begin && nums[mid] < nums[mid-1] && mid < end &&  nums[mid] > nums[mid+1]) {
            return find(nums, begin ,mid -1);//向左找
        } else if(mid > begin && nums[mid] > nums[mid-1] && mid < end &&  nums[mid] < nums[mid+1]){
            return find(nums, mid+1, end);//向右
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4,5,6,4};
        int i = find(nums, 0, nums.length-1);
        System.out.println(i);

    }
}
