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
	      //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
	        Statement stmt = new DBhelper().getConnection().createStatement();
	        //ResultSet executeQuery(String sqlString)��ִ�в�ѯ���ݿ��SQL���   ������һ���������ResultSet������
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
