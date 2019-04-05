package com.popo.jdbc;

import java.sql.*;




public class Test {
	
	 //这里可以设置数据库名称
    private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
    private static final String USER="sa";
    private static final String PASSWORD="123456";
    
    private static Connection conn=null;
    //静态代码块（将加载驱动、连接数据库放入静态块中）
    static{
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
    }
    
    //对外提供一个方法来获取数据库连接
    public static Connection getConnection(){
        return conn;
    }
    
    public static void createBrandDatabase() throws SQLException{
    	ResultSet rs =new DBhelper().getConnection().getMetaData().getTables(null,null, "student",null );
    	if(rs.next()) {
System.out.println("在");
    		//yourTableexist
    		}else {
    		//yourTablenotexist
    			System.out.println("No");
    		}
    	
	}
    //测试用例
    public static void main(String[] args) throws Exception{
    	createBrandDatabase();
        //3.通过数据库的连接操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        //ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句   ，返回一个结果集（ResultSet）对象。
        ResultSet rs = stmt.executeQuery("select * from student");
        while(rs.next()){//如果对象中有数据，就会循环打印出来
            System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getString("sex")+","+rs.getInt("num"));
        }
    }

}
