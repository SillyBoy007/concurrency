package com.example.learn.concurrency.c06_lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock()的正确使用方法
 */
public class ReentrantLockDemo {
    private ArrayList<Integer> arrayList=new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final ReentrantLockDemo test = new ReentrantLockDemo();
        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

    }
    public void insert(Thread thread){
         //Lock lock = new ReentrantLock(); //错误的使用方法,将lock声明为属性

        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for (int i=0;i<5;i++){
                arrayList.add(i);
            }
        }catch (Exception e){

        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
