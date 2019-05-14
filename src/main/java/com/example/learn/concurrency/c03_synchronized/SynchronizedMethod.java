package com.example.learn.concurrency.c03_synchronized;

/**
 * 一个线程获取了该对象的锁之后，其他线程来访问其他synchronized实例方法现象
 */
public class SynchronizedMethod {
    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }
    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final SynchronizedMethod synchronizedMethod = new SynchronizedMethod();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedMethod.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedMethod.method2();
            }
        }).start();
    }
    //可以看出其他线程来访问synchronized修饰的其他方法时需要等待线程1先把锁释放
}
