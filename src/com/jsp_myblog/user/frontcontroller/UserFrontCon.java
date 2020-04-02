package com.jsp_myblog.user.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp_myblog.user.command.UserCommand;
import com.jsp_myblog.user.command.UserSignupCommand;
import com.jsp_myblog.user.command.UserLoginCommand;
import com.jsp_myblog.user.command.UserLogoutCommand;

@WebServlet("*.user")
public class UserFrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserFrontCon() {
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
		UserCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.contentEquals("/signup_view.user")) {
			viewPage = "signup.jsp";
		}
		else if(com.contentEquals("/signup.user")) {
			command = new UserSignupCommand();
			viewPage = command.execute(request, response);
		}
		else if(com.contentEquals("/login_view.user")) {
			viewPage = "login.jsp";
		}
		else if(com.contentEquals("/login.user")) {
			command = new UserLoginCommand();
			viewPage = command.execute(request, response);
		}
		else if(com.contentEquals("/logout.user")) {
			command = new UserLogoutCommand();
			viewPage = command.execute(request, response);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
