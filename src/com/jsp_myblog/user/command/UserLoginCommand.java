package com.jsp_myblog.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp_myblog.user.dao.UserDao;

public class UserLoginCommand implements UserCommand {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserDao dao = new UserDao();
		
		try {
			String name = dao.login(id, password);
			
			if(name != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", id);
				session.setAttribute("username", name);
				return "list.do";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "login_view.user";
	}
}
