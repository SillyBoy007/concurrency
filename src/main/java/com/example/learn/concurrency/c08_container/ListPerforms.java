package com.example.learn.concurrency.c08_container;

import java.util.ArrayList;
import java.util.Vector;

/**
 同步容器性能问题

 数据量为1000000
 ArrayList进行100000次插入操作耗时：12ms
 Vector进行100000次插入操作耗时：46ms

 数据量为10000000
 ArrayList进行100000次插入操作耗时：3048ms
 Disconnected from the target VM, address: '127.0.0.1:52740', transport: 'socket'
 Vector进行100000次插入操作耗时：406ms

 初始化容器大小后

 数据量为1000000
 ArrayList进行100000次插入操作耗时：18ms
 Vector进行100000次插入操作耗时：44ms

 数据量为10000000
 ArrayList进行100000次插入操作耗时：2897ms
 Disconnected from the target VM, address: '127.0.0.1:52761', transport: 'socket'
 Vector进行100000次插入操作耗时：1023ms
 */
public class ListPerforms {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(1);
        Vector<Integer> vector = new Vector<Integer>(1);
        long start = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行100000次插入操作耗时："+(end-start)+"ms");

        start = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            vector.add(i);

        }
        end = System.currentTimeMillis();
        System.out.println("Vector进行100000次插入操作耗时："+(end-start)+"ms");

    }
}
