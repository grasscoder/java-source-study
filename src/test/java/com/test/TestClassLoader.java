package com.test;

public class TestClassLoader {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(System.getProperty("java.class.path"));

        ClassLoader cl = TestClassLoader.class.getClassLoader();
        System.out.println("ClassLoader is: "+cl.getParent().getParent().toString());
    }
}
