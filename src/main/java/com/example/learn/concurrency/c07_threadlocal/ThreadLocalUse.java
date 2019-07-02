package com.example.learn.concurrency.c07_threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ThreadLocal实际运用
 * 最常见的ThreadLocal使用场景为 用来解决 数据库连接、Session管理等。
 */
public class ThreadLocalUse {
    private static final ThreadLocal threadSession = new ThreadLocal();

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection("");
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
