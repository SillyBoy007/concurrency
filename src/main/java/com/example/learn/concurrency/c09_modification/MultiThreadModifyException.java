package com.example.learn.concurrency.c09_modification;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 虽然Vector的方法采用了synchronized进行了同步，但是实际上通过Iterator访问的情况下，每个线程里面返回的是不同的iterator，也即是说expectedModCount是每个线程私有。假若此时有2个线程，线程1在进行遍历，线程2在进行修改，那么很有可能导致线程2修改后导致Vector中的modCount自增了，线程2的expectedModCount也自增了，但是线程1的expectedModCount没有自增，此时线程1遍历时就会出现expectedModCount不等于modCount的情况了。
 *
 *
 */
public class MultiThreadModifyException {
        static ArrayList<Integer> list = new ArrayList<Integer>();
        public static void main(String[] args)  {
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            Thread thread1 = new Thread(){
                public void run() {
                    Iterator<Integer> iterator = list.iterator();
                    while(iterator.hasNext()){
                        Integer integer = iterator.next();
                        System.out.println(integer);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
            };
            Thread thread2 = new Thread(){
                public void run() {
                    Iterator<Integer> iterator = list.iterator();
                    while(iterator.hasNext()){
                        Integer integer = iterator.next();
                        if(integer==2)
                            iterator.remove();
                    }
                };
            };
            thread1.start();
            thread2.start();
        }

}
