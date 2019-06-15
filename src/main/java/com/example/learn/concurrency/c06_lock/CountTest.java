package com.example.learn.concurrency.c06_lock;

/**
 * 验证可重入锁与不可重入锁
 */
public class CountTest {
    UnReentrantLockTest ul = new UnReentrantLockTest();
    public void print(){
        try {
            ul.lock();
            doAdd();
            ul.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void doAdd(){
        try {
            ul.lock();
            ul.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    ReentrantLockTest  reentrantLockTest = new ReentrantLockTest();
    public void rPrint(){
        try {
            reentrantLockTest.lock();
            rDoAdd();
            reentrantLockTest.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void rDoAdd(){
        try {
            reentrantLockTest.lock();
            reentrantLockTest.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        CountTest count = new CountTest();
        //count.print();
        count.rPrint();
    }
}

