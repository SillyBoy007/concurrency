package com.example.learn.concurrency.c04_volatile;

/**
 * 没有加锁无法保证原子性
 */
public class VolatileTest {
    public volatile int inc = 0;
    public void increase(){
        inc ++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for (int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    for (int j=0;j<1000;j++){
                        test.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount()>1){  //保证前面的线程执行完
            Thread.yield();
        }
        System.out.println(test.inc);
    }
}
