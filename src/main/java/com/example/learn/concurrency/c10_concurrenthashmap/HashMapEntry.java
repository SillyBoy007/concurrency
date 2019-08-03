package com.example.learn.concurrency.c10_concurrenthashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 参考:https://www.cnblogs.com/fsychen/p/9361858.html
 * HashMap遍历
 *
 *
 */
public class HashMapEntry {
    /**
     * 强烈建议使用第一种 EntrySet 进行遍历。
     * 第一种可以把 key value 同时取出，第二种还得需要通过 key 取一次 value，效率较低。
     * 简单总结下 HashMap：无论是 1.7 还是 1.8 其实都能看出 JDK 没有对它做任何的同步操作，所以并发会出问题，甚至出
        现死循环导致系统不可用。
     * @param args
     */
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("wang",1);
        //第一种
        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> next = entryIterator.next();
            System.out.println("key=" + next.getKey() + " value=" + next.getValue());
        }
        //第二种
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println("key=" + key + " value=" + map.get(key));

        }
    }

}
