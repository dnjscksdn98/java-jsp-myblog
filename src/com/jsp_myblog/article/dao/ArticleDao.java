package com.jsp_myblog.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsp_myblog.article.dto.ArticleDto;
import com.jsp_myblog.util.JdbcUtil;


public class ArticleDao {
	private DataSource dataSource;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String ARTICLE_WRITE = "insert into articles(id, writer, title, content) values (articles_seq.nextval, ?, ?, ?)";
	private final String ARTICLE_LIST = "select * from articles order by rdate desc";
	private final String ARTICLE_UPDATE_VIEWS = "update articles set views = views + 1 where id = ?";
	private final String ARTICLE_DETAIL = "select * from articles where id = ?";
	private final String ARTICLE_UPDATE = "update articles set writer = ?, title = ?, content = ? where id = ?";
	private final String ARTICLE_DELETE = "delete from articles where id = ?";
	
	public ArticleDao() {		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(String writer, String title, String content) {		
		
		try {
			conn = dataSource.getConnection();
			String query = ARTICLE_WRITE;
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(pstmt, conn);
		}
	}
	
	public ArrayList<ArticleDto> list(){
		ArrayList<ArticleDto> dtos = new ArrayList<ArticleDto>();
		
		try {
			conn = dataSource.getConnection();
			String query = ARTICLE_LIST;
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp rdate = rs.getTimestamp("rdate");
				int views = rs.getInt("views");
				
				ArticleDto dto = new ArticleDto(id, writer, title, content, rdate, views);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeResource(rs, pstmt, conn);
		}
		return dtos;
	}
	
	private void increaseViews(String articleId) {
		
		try {
			conn = dataSource.getConnection();
			String query = ARTICLE_UPDATE_VIEWS;
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, articleId);
			
			pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(pstmt, conn);
		}
	}
	
	public ArticleDto detailView(String articleId) {
		increaseViews(articleId);
		ArticleDto dto = null;
		
		try {
			conn = dataSource.getConnection();
			String query = ARTICLE_DETAIL;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(articleId));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp rdate = rs.getTimestamp("rdate");
				int views = rs.getInt("views");
				
				dto = new ArticleDto(id, writer, title, content, rdate, views);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void update(String id, String writer, String title, String content) {
		
		try {
			conn = dataSource.getConnection();
			String query = ARTICLE_UPDATE;
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, Integer.parseInt(id));
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(pstmt, conn);
		}
	}
	
	public void delete(String articleId) {
		
		try {
			conn = dataSource.getConnection();
			String query = ARTICLE_DELETE;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(articleId));
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(pstmt, conn);
		}
	}
}
