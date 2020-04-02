package com.jsp_myblog.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLogoutCommand implements UserCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
		HttpSession session = request.getSession();
		session.invalidate();
		return "list.do";
	}
}
