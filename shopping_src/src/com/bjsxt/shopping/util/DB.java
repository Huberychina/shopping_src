package com.bjsxt.shopping.util;

import java.sql.*;

public class DB {
	private static DB db;
	
	static{
		db = new DB();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private DB(){}
	public static Connection getConn(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?user=root&password=123456");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConn(Connection conn){
		try{
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public static Statement getStmt(Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	

	public static PreparedStatement prepStmt(Connection conn, String sql){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	
	public static void closeStmt(Statement stmt){
		try{
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static ResultSet executeQuery(Statement stmt,String sql){
		ResultSet  rs = null;
		try{
			rs = stmt.executeQuery(sql);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}

}
