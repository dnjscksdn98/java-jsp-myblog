package com.jsp_myblog.article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp_myblog.article.dao.ArticleDao;


public class ArticleWriteCommand implements ArticleCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		ArticleDao dao = new ArticleDao();
		dao.write(writer, title, content);
	}
}