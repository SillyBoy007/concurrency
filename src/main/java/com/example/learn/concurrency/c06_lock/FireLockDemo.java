package com.example.learn.concurrency.c06_lock;

import java.util.concurrent.locks.ReentrantLock;

public class FireLockDemo implements Runnable{
    /**
     * true是公平锁
     * 默认false为非公平锁
     */
    public static ReentrantLock fairLock = new ReentrantLock(true);


    @Override
    public void run() {
        while (true){
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+"，获得锁!");
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FireLockDemo fireLockDemo = new FireLockDemo();

        Thread thread1 = new Thread(fireLockDemo, "线程1");
        Thread thread2 = new Thread(fireLockDemo, "线程2");
        thread1.start();
        thread2.start();
    }
}
