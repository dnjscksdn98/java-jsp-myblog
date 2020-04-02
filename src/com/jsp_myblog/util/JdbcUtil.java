package com.jsp_myblog.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
	public static void closeResource(PreparedStatement pstmt, Connection conn){
		try {
			if(pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			pstmt = null;
		}
		try {
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			conn = null;
		}
	}
	
	public static void closeResource(ResultSet rs, PreparedStatement pstmt, Connection conn){
		try {
			if(rs != null)
				rs.close();
		} catch (Exception e) {
			rs = null;
		}
		try {
			if(pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			pstmt = null;
		}
		try {
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			conn = null;
		}
	}
}
