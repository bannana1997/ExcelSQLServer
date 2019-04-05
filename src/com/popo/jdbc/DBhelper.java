package com.popo.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.popo.po.Stu;

import java.sql.*;

public class DBhelper {
	 //这里可以设置数据库名称
    private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
    private static final String USER="sa";
    private static final String PASSWORD="123456";
    
    private Connection conn=null;
    
    public Connection getConnection(){
    //静态代码块（将加载驱动、连接数据库放入静态块中）
        try {
            //1.加载驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.获得数据库的连接
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        
    }   
        return conn;
    }
}
