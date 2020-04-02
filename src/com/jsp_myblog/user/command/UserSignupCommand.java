package com.jsp_myblog.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp_myblog.user.dao.UserDao;

public class UserSignupCommand implements UserCommand {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		UserDao dao = new UserDao();
		
		try {
			dao.signup(id, password, name, email);
			return "signup_success.jsp";
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "signup_view.user";
	}
}
