package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TestSubString {
    static List<List<Character>> outList = new ArrayList<>();
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        char[] charArr = s1.toCharArray();
        List<Character> l = new ArrayList<>();
        int[] arr = new int[128];
        backTrack(charArr, l, arr);
        for(int i = 0; i< outList.size(); i++){
           // System.out.println(new String((Character[]) outList.get(i).toArray()));
        }
    }
    public static void backTrack(char[] ss, List<Character> list, int[] arr) {
        if(list.size() == ss.length){
            outList.add(list);
            return;
        }
        for(int i = 0; i < ss.length; i++){
            if(arr[ss[i]] == 1){
                continue;
            }
            if(i > 0 && ss[i] == ss[i-1] && arr[i-1] == 0)
                continue;
            list.add(ss[i]);
            arr[i] = 1;
            backTrack(ss, list, arr);
            list.remove(list.size() - 1);
            arr[i] = 0;
        }
    }
}
