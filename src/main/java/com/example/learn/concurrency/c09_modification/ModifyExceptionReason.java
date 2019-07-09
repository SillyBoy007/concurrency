package com.example.learn.concurrency.c09_modification;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 调用list.remove()方法导致modCount和expectedModCount的值不一致。
 */
public class ModifyExceptionReason {
    public static class Test {
        public static void main(String[] args)  {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(2);
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()){
                Integer integer = iterator.next();
                if(integer==2)
                  //  list.remove(integer);
                    iterator.remove();
            }
        }
    }
}
