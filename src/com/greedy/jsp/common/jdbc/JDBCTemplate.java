package com.greedy.jsp.common.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.greedy.jsp.common.config.ConfigLocation;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		
		Connection con = null;
		//Connection은 데이터베이스와 연결하는 객체이다.
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));
			//filereader에는 경로에 대한 문자열이 있어야함 그러므로 configlocation가서 가져옴
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			
			Class.forName(driver);
			//드라이버설정
			con = DriverManager.getConnection(url, prop);
			//데이터베이스 연결 
			con.setAutoCommit(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static void close(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}













