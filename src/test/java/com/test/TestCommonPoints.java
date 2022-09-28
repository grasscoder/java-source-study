package com.test;

/*
* 马斯克不喜欢X轴上有线段，他有一种清洗剂，当滴在X轴上的某一点时，会将该点所在的线段擦除掉，
* 如果滴在多条线段的公共交点上会清除交点的所有线段。但是不会传递清除与当前这些线段有交点的其他线段
* 例：
* (4,0)(6,0)(5.0)表示X轴上的三条线段，
*
* */
public class TestCommonPoints {
    private String AA = "aa";
    public String BB = "bb";
    class A {
        String CC = "cc";
        public String get(){

           return BB + AA;
        }
    }

}
