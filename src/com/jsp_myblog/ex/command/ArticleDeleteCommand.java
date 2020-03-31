package com.jsp_myblog.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp_myblog.ex.dao.ArticleDao;

public class ArticleDeleteCommand implements ArticleCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		String articleId = request.getParameter("id");
		ArticleDao dao = new ArticleDao();
		dao.delete(articleId);
		
	}
}
