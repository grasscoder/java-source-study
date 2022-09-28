package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestAbsMinvalues {
    public static int findMin(int[] arr, int begin, int end) {
        int min = 10001;
        int index = -1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (mid - 1 >= 0 && arr[mid] <= arr[mid - 1] && mid + 1 <= arr.length && arr[mid] <= arr[mid + 1]) {
                if (arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                    break;
                }
            } else if (mid - 1 >= 0 && arr[mid] <= arr[mid - 1] && mid + 1 <= arr.length && arr[mid] >= arr[mid + 1]) {
                begin = mid;
            } else if (mid - 1 >= 0 && arr[mid] >= arr[mid - 1] && mid + 1 <= arr.length && arr[mid] <= arr[mid + 1]) {
                end = mid;
            }
        }
        for (int i = index; i >= 1; i--) {
            if (arr[i - 1] == arr[i]) {
                index = i - 1;
            }
        }
        return index;
    }

    public static List<Integer> find(int[] arr, int k, int x) {
        List<Integer> list = Stream.of(arr).flatMapToInt(Arrays::stream).boxed().sorted((a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        }).limit(k).sorted().collect(Collectors.toList());
        List<Integer> list1 = Arrays.stream(arr).boxed().sorted((a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        }).limit(k).sorted().collect(Collectors.toList());
        return list;
        //
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 1, 1, 1, 1, 5, 6};
        System.out.println(find(arr, 5, 0));
    }
}
