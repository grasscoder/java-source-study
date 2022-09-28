package com.test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(4, 0.75f);
        for(Integer i = 0; i < 4; i++){
            map.put(i.toString(), i);
        }
    }
}
