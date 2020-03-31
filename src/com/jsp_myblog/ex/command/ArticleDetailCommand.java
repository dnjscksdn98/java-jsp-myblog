package com.jsp_myblog.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp_myblog.ex.dao.ArticleDao;
import com.jsp_myblog.ex.dto.ArticleDto;

public class ArticleDetailCommand implements ArticleCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String articleId = request.getParameter("id");
		ArticleDao dao = new ArticleDao();
		ArticleDto dto = dao.detailView(articleId);
		
		request.setAttribute("detail_view", dto);
		
	}
}
