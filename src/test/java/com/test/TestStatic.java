package com.test;

import java.util.HashMap;

class Father {
    static {
        System.out.println("父类【静态块】执行");
    }
    {
        System.out.println("父类【构造块】执行");
    }
}
public class TestStatic extends Father{
    static {
        System.out.println("子类【静态块】执行");
    }
    {
        System.out.println("子类【构造块】执行");
    }

    public static void main(String[] args) {
        System.out.println("子类main方法开始执行");
        TestStatic s = new TestStatic();
        System.out.println("子类main方法执行完毕");
        HashMap<String, String> map = new HashMap<>(16);

    }
}
