package com.jsp_myblog.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsp_myblog.user.dto.UserDto;
import com.jsp_myblog.util.JdbcUtil;

public class UserDao {
	private DataSource dataSource;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String USER_CHECK = "select * from users where id = ?";
	private final String USER_SIGNUP = "insert into users(id, password, name, email) values(?, ?, ?, ?)";
	private final String USER_LOGIN = "select name from users where id = ? and password = ?";
	
	public UserDao() {		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkUser(String id) {
		try {
			conn = dataSource.getConnection();
			String query = USER_CHECK;
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(rs, pstmt, conn);
		}
		return true;
	}
	
	public void signup(String id, String password, String name, String email) {
		try {
			if(checkUser(id)) {
				conn = dataSource.getConnection();
				String query = USER_SIGNUP;
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				pstmt.setString(3, name);
				pstmt.setString(4, email);
				pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(pstmt, conn);
		}
	}
	
	public String login(String id, String password) {
		try {
			conn = dataSource.getConnection();
			String query = USER_LOGIN;
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("name");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(rs, pstmt, conn);
		}
		return null;
	}
}
