package com.example.learn.concurrency.c08_container;

import java.util.Vector;

/**
 *为了保证线程安全，必须在方法调用端做额外的同步措施，如下面所示：
 */
public class SyncSaveTest {
    static Vector<Integer> vector = new Vector<Integer>();

    public static synchronized void increase(){
        for(int i=0;i<10;i++)
            vector.add(i);
    }
    public static void main(String[] args) throws InterruptedException {
        boolean flag = true;
        while(flag) {
            for(int i=0;i<10;i++)
                vector.add(i);
            Thread thread1 = new Thread(){
                public void run() {
                    synchronized (SyncSaveTest.class) {   //进行额外的同步
                        for(int i=0;i<10;i++)
                            vector.add(i);
                    }

                };
            };
            Thread thread2 = new Thread(){
                public void run() {
                    synchronized (SyncSaveTest.class) {   //进行额外的同步
                        for(int i=0;i<10;i++)
                            vector.add(i);
                    }
                };
            };
            thread1.start();
            thread2.start();
            while(Thread.activeCount()>10)   {
                flag = false;
            }
        }
    }
}
