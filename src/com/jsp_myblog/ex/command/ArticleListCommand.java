package com.jsp_myblog.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp_myblog.ex.dao.ArticleDao;
import com.jsp_myblog.ex.dto.ArticleDto;

public class ArticleListCommand implements ArticleCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		ArticleDao dao = new ArticleDao();
		ArrayList<ArticleDto> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}
