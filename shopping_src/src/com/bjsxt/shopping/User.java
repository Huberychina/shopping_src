package com.bjsxt.shopping;

import java.sql.*;

import com.bjsxt.shopping.util.DB;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String phone;
	private String addr;
	private Timestamp rdate;
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	public void save(){
		Connection conn = DB.getConn();
		String sql = "insert into ruser values (null,?,?,?,?,?)";
		PreparedStatement pstmt = DB.prepStmt(conn,sql);
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, phone);
			pstmt.setString(4, addr);
			pstmt.setTimestamp(5, new Timestamp(rdate.getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		
	}
	
}
