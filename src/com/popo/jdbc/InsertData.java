package com.popo.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.popo.po.Stu;

public class InsertData {
	
	public void dropTable() throws SQLException{
		System.out.println("dropTable");
		Connection conn= new DBhelper().getConnection();
		Statement stmt = conn.createStatement();
		String sql = "drop table student";
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
	}
	
	public void createTable() throws SQLException{
		System.out.println("createTable");
		Connection conn= new DBhelper().getConnection();
		Statement stmt = conn.createStatement();
		String sql = "create table student("
		+ "id int not null primary key,"
	    + "name varchar(50),"
		+ "sex varchar(50)," 
	    + "num int"
	    + ")";
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
	}
	
	public  boolean createBrandDatabase() throws SQLException{
		boolean flag = false;
		Connection conn= new DBhelper().getConnection();
		ResultSet rs = null;
		try {
			rs =conn.getMetaData().getTables(null,null, "student",null );
			if(rs.next()) {
				System.out.println("��");
				dropTable();
				createTable();
				flag = true;
    		}else{
    			System.out.println("����");
    		//yourTablenotexist
    			createTable();
    			flag = true;
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			rs.close();
			conn.close();
		}
		return flag;
    	
	}
	 public void InsertAllToDb(List<Stu> student) throws SQLException{
	        List<Stu> list = new ArrayList<Stu>();
	        list = student;
	        Connection conn= new DBhelper().getConnection();
	        Statement stmt = null;
	        for(int i=0;i<list.size();i++){
	        try {
	      //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
	        stmt = conn.createStatement();
	        //ResultSet executeQuery(String sqlString)��ִ�в�ѯ���ݿ��SQL���   ������һ���������ResultSet������
	        String sql = "insert into student values('" 
	        + list.get(i).getId() + "','" 
	        + list.get(i).getName() + "','"
	        + list.get(i).getSex() + "','"
	        + list.get(i).getNum() + "')" ;
	        stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	        	stmt.close();
	        	conn.close();
	        }
	        }
	    }

}
