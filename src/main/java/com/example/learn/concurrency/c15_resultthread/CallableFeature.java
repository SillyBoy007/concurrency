package com.example.learn.concurrency.c15_resultthread;

import java.util.concurrent.*;

/**
 * 使用Callable+Future获取执行结果
 */
public class CallableFeature {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Long> result = executor.submit(task);
        executor.shutdown();

        try {
            //Thread.sleep(1000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        System.out.println("子线程在进行计算");
        //Thread.sleep(3000);
        long sum = 0;
        for(long i=0;i<1000000000;i++)
            sum += i;
        return sum;
    }
}

