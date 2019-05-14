package com.example.learn.concurrency.c05_final;

/**
 * final修饰成员变量
 */
public class MemberVar {
    private final int a = 6;
    private final String str;
    private final static boolean b;
    private final char ch = 'a';
    private final double c;
    {
        //实例变量可以在初始化块中赋值
        str = "初始化str";

    }
    static {
        //类变量(静态变量)可以在静态初始化块中赋值
        b = false;
    }
    public MemberVar(){
        c = 1.0;
    }

}
