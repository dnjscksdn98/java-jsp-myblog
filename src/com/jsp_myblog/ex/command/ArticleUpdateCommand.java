package com.jsp_myblog.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp_myblog.ex.dao.ArticleDao;

public class ArticleUpdateCommand implements ArticleCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		ArticleDao  dao = new ArticleDao();
		dao.update(id, writer, title, content);
	}
}
