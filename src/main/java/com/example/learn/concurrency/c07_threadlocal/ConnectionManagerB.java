package com.example.learn.concurrency.c07_threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 由于每次都是在方法内部创建的连接，那么线程之间自然不存在线程安全问题
 * 但是这样会有一个致命的影响：导致服务器压力非常大，并且严重影响程序执行性能。由于在方法中需要频繁地开启和关闭数据库连接，这样不尽严重影响程序执行效率，还可能导致服务器压力巨大。
 */
public class ConnectionManagerB {
    private Connection connect = null;

    public Connection openConnection() {
        if(connect == null){
            try {
                connect = DriverManager.getConnection("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    public void closeConnection() {
        if(connect!=null)
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    class Dao{
        public void insert() {
            ConnectionManagerB connectionManager = new ConnectionManagerB();
            Connection connection = connectionManager.openConnection();

            //使用connection进行操作

            connectionManager.closeConnection();
        }
    }

}
