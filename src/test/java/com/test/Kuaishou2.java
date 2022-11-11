package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class Kuaishou2 {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String[] arr = {"aa", "bb", "cc", "aa","bb"};
        method(arr);

    }

    public static void method(String[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
        Comparator cmp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        };

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(cmp);
        for (Map.Entry<String, Integer> element : list)
            queue.add(element);
        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> entries = queue.poll();
            System.out.println(entries.getKey() + " == " + entries.getValue());
        }
    }
}
