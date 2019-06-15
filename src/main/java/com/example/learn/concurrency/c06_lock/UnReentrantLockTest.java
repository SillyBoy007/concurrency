package com.example.learn.concurrency.c06_lock;

/**
 * 实现不可重入锁
 */
public class UnReentrantLockTest {
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        while (isLocked){
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }

}
