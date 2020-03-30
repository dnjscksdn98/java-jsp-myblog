package com.jsp_myblog.ex.dto;

import java.sql.Timestamp;

public class ArticleDto {
	int id;
	String writer;
	String title;
	String content;
	Timestamp rdate;
	int views;
	int aGroup;
	int aStep;
	int aIndent;
	
	public ArticleDto() {
	}
	
	public ArticleDto(int id, String writer, String title, String content, Timestamp rdate, int views, int aGroup, int aStep, int aIndent) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.views = views;
		this.aGroup = aGroup;
		this.aStep = aStep;
		this.aIndent = aIndent;
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

	public int getAGroup() {
		return this.aGroup;
	}

	public void setAGroup(int aGroup) {
		this.aGroup = aGroup;
	}

	public int getAStep() {
		return this.aStep;
	}

	public void setAStep(int aStep) {
		this.aStep = aStep;
	}

	public int getAIndent() {
		return this.aIndent;
	}

	public void setAIndent(int aIndent) {
		this.aIndent = aIndent;
	}
}
