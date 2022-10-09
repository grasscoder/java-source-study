package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "c");
        Map<String, String> map = list.stream().collect(Collectors.toMap(k -> k, v -> v, (k1, k2) -> k1));
        System.out.println(map);
        System.out.println(list.stream().sorted().peek(a-> System.out.println(a)).toArray());
    }
}
