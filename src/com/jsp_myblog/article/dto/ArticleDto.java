package com.jsp_myblog.article.dto;

import java.sql.Timestamp;

public class ArticleDto {
	int id;
	String writer;
	String title;
	String content;
	Timestamp rdate;
	int views;
	
	public ArticleDto() {
	}
	
	public ArticleDto(int id, String writer, String title, String content, Timestamp rdate, int views) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.views = views;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRDate() {
		return this.rdate;
	}

	public void setRDate(Timestamp rdate) {
		this.rdate = rdate;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}
}
