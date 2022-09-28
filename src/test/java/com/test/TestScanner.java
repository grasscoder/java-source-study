package com.test;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); // 注意：会吸收上一次输完一个字符串后按下的 Enter 和 Tab
        System.out.println(s);
        int i = sc.nextInt();
        System.out.println(i);
        float f = sc.nextFloat();
        System.out.println(f);

    }
}
