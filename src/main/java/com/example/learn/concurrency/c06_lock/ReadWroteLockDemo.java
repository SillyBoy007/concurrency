package com.example.learn.concurrency.c06_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadWroteLockDemo {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args)  {
        final ReadWroteLockDemo test = new ReadWroteLockDemo();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

//    public synchronized void get(Thread thread) {
//        long start = System.currentTimeMillis();
//        while(System.currentTimeMillis() - start <= 1) {
//            System.out.println(thread.getName()+"正在进行读操作");
//        }
//        System.out.println(thread.getName()+"读操作完毕");
//    }
    public void get (Thread thread){
        readWriteLock.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
