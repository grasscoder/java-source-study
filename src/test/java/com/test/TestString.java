package com.test;

public class TestString {
    public static boolean solve (String A, String B) {
        return A.length()==B.length()&&(A+A).substring(1,2*A.length()-1).contains(B);
        // write code here
    }
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
