package com.jsp_myblog.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp_myblog.ex.command.ArticleCommand;
import com.jsp_myblog.ex.command.ArticleWriteCommand;
import com.jsp_myblog.ex.command.ArticleListCommand;
import com.jsp_myblog.ex.command.ArticleDetailCommand;
import com.jsp_myblog.ex.command.ArticleUpdateCommand;
import com.jsp_myblog.ex.command.ArticleDeleteCommand;


@WebServlet("*.do")
public class ArticleFrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ArticleFrontCon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		ArticleCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.contentEquals("/write_view.do")) {
			viewPage = "write_view.jsp";
		}
		else if(com.contentEquals("/write.do")) {
			command = new ArticleWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.contentEquals("/list.do")) {
			command = new ArticleListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		else if(com.contentEquals("/detail_view.do")) {
			command = new ArticleDetailCommand();
			command.execute(request, response);
			viewPage = "detail_view.jsp";
		}
		else if(com.contentEquals("/update.do")) {
			command = new ArticleUpdateCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.contentEquals("/delete.do")) {
			command = new ArticleDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
