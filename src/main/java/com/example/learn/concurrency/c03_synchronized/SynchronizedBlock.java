package com.example.learn.concurrency.c03_synchronized;

import java.util.concurrent.locks.Lock;

public class SynchronizedBlock implements Runnable {
    static SynchronizedBlock instance=new SynchronizedBlock();

    static int i=0;

    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized(instance){
            for(int j=0;j<10000;j++){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
