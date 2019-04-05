package com.popo.jdbc;

import java.sql.*;




public class Test {
	
	 //��������������ݿ�����
    private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
    private static final String USER="sa";
    private static final String PASSWORD="123456";
    
    private static Connection conn=null;
    //��̬����飨�������������������ݿ���뾲̬���У�
    static{
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
    }
    
    //�����ṩһ����������ȡ���ݿ�����
    public static Connection getConnection(){
        return conn;
    }
    
    public static void createBrandDatabase() throws SQLException{
    	ResultSet rs =new DBhelper().getConnection().getMetaData().getTables(null,null, "student",null );
    	if(rs.next()) {
System.out.println("��");
    		//yourTableexist
    		}else {
    		//yourTablenotexist
    			System.out.println("No");
    		}
    	
	}
    //��������
    public static void main(String[] args) throws Exception{
    	createBrandDatabase();
        //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
        Statement stmt = conn.createStatement();
        //ResultSet executeQuery(String sqlString)��ִ�в�ѯ���ݿ��SQL���   ������һ���������ResultSet������
        ResultSet rs = stmt.executeQuery("select * from student");
        while(rs.next()){//��������������ݣ��ͻ�ѭ����ӡ����
            System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getString("sex")+","+rs.getInt("num"));
        }
    }

}
