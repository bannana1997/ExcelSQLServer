package com.popo.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.popo.po.Stu;

import java.sql.*;

public class DBhelper {
	 //��������������ݿ�����
    private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
    private static final String USER="sa";
    private static final String PASSWORD="123456";
    
    private Connection conn=null;
    
    public Connection getConnection(){
    //��̬����飨�������������������ݿ���뾲̬���У�
        try {
            //1.������������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.������ݿ������
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        
    }   
        return conn;
    }
}
