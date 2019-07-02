package com.example.learn.concurrency.c07_threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 第一，这里面的2个方法都没有进行同步，很可能在openConnection方法中会多次创建connect；第二，由于connect是共享变量，那么必然在调用connect的地方需要使用到同步来保障线程安全，因为很可能一个线程在使用connect进行数据库操作，而另外一个线程调用closeConnection关闭链接。
 */
public class ConnectionManagerA {
    private static Connection connect = null;

    public static Connection openConnection() {
        if(connect == null){
            try {
                connect = DriverManager.getConnection("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    public static void closeConnection() {
        if(connect!=null)
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
