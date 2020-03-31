package com.jsp_myblog.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsp_myblog.ex.dto.ArticleDto;


public class ArticleDao {
	DataSource dataSource;
	
	public ArticleDao() {		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(String writer, String title, String content) {		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into articles(id, writer, title, content, views, aGroup, aStep, aIndent) values (articles_seq.nextval, ?, ?, ?, 0, articles_seq.currval, 0, 0)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, writer);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, content);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<ArticleDto> list(){
		ArrayList<ArticleDto> dtos = new ArrayList<ArticleDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select id, writer, title, content, rdate, views, aGroup, aStep, aIndent from articles order by aGroup desc, aStep asc";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String writer = resultSet.getString("writer");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				Timestamp rdate = resultSet.getTimestamp("rdate");
				int views = resultSet.getInt("views");
				int aGroup = resultSet.getInt("aGroup");
				int aStep = resultSet.getInt("aStep");
				int aIndent = resultSet.getInt("aIndent");
				
				ArticleDto dto = new ArticleDto(id, writer, title, content, rdate, views, aGroup, aStep, aIndent);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	private void increaseViews(String articleId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update articles set views = views + 1 where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, articleId);
			
			preparedStatement.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArticleDto detailView(String articleId) {
		increaseViews(articleId);
		
		ArticleDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from articles where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(articleId));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int id = resultSet.getInt("id");
				String writer = resultSet.getString("writer");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				Timestamp rdate = resultSet.getTimestamp("rdate");
				int views = resultSet.getInt("views");
				int aGroup = resultSet.getInt("aGroup");
				int aStep = resultSet.getInt("aStep");
				int aIndent = resultSet.getInt("aIndent");
				
				dto = new ArticleDto(id, writer, title, content, rdate, views, aGroup, aStep, aIndent);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void update(String id, String writer, String title, String content) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update articles set writer = ?, title = ?, content = ? where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, writer);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, content);
			preparedStatement.setInt(4, Integer.parseInt(id));
			preparedStatement.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(String articleId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "delete from articles where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(articleId));
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
