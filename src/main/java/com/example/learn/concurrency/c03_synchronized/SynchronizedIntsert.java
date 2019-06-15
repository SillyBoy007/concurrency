package com.example.learn.concurrency.c03_synchronized;

import java.util.ArrayList;

public class SynchronizedIntsert {
    public static void main(String[] args) {
        final InsertData insertData = new InsertData();
        new Thread(){
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();
    }

    static class InsertData {
        private ArrayList<Integer> arrayList = new ArrayList<>();
        public  synchronized void  insert(Thread thread){
            for (int i=0;i<5;i++){
                System.out.println(thread.getName()+"在插入数据"+i);
                arrayList.add(i);
                try {
                    thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
