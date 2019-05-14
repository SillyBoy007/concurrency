package com.example.learn.concurrency.c04_volatile;

/**
 * volatile修饰的变量被所有线程共享
 */
public class VolatileDemo {
    private static volatile boolean isOver = false;
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) ;
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}
