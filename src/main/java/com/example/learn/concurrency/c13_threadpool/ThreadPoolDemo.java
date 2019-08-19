package com.example.learn.concurrency.c13_threadpool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 参考链接: https://www.cnblogs.com/dolphin0520/p/3932921.html
 *
 * private volatile int   corePoolSize;     //核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
 * private volatile int   maximumPoolSize;   //线程池最大能容忍的线程数
 * private volatile long  keepAliveTime;    //线程存货时间
 *
 * private final BlockingQueue<Runnable> workQueue;              //任务缓存队列，用来存放等待执行的任务
 *
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中的数目:"+executor.getPoolSize()+",队列中等待执行的数目:"+
            executor.getQueue().size()+",已执行完别的任务数目:"+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    static class MyTask implements Runnable{
        private int taskNum;

        public MyTask(int taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            System.out.println("正在执行task"+taskNum);
            try {
                Thread.sleep(4000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("task"+taskNum+"执行完毕");
        }

    }
}
