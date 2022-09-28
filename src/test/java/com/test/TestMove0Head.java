package com.test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 将数组中的0移动到数组的后面位置，保证非零数组元素的位置相对不变
 * */
public class TestMove0Head {
    public static int[] move0ToHead(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int len = nums.length;
        int point = 0;
        for (int i = 0; i < len; ) {
            if (nums[i] == 0) {
                for (int j = point > (i + 1) ? point : (i + 1); j < len; ) {
                    if (nums[j] == 0) {
                        j++;
                    } else {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        point = j;
                        break;
                    }
                }
            }
            i++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 0, 0, 4, 1};
        int[] nums = move0ToHead(arr);
        System.out.println(Arrays.toString(nums));
        Stream.of(arr).collect(Collectors.toList());

    }
}
