package com.example.learn.concurrency.c02_thread;

public class SleepTest {
    private int i = 30;
    private Object object = new Object();

    public static void main(String[] args) {
         SleepTest sleepTest = new SleepTest();
        MyThread myThread1 = sleepTest.new MyThread();
        MyThread myThread2 = sleepTest.new MyThread();
        myThread1.start();
        myThread2.start();

    }
    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object){
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }
}
