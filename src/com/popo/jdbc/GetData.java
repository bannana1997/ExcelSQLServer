package com.popo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.popo.po.Stu;

import java.sql.*;
public class GetData {
	
	 public List<Stu> getAllByDb() throws SQLException{
	        List<Stu> list = new ArrayList<Stu>();
	      //3.通过数据库的连接操作数据库，实现增删改查
	        Statement stmt = new DBhelper().getConnection().createStatement();
	        //ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句   ，返回一个结果集（ResultSet）对象。
	        ResultSet rs = stmt.executeQuery("select * from student");
	        try {
	            while(rs.next()){
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String sex = rs.getString("sex");
	                int num = rs.getInt("num");
	                list.add(new Stu(id,name,sex,num));
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return list;
	    }

}
