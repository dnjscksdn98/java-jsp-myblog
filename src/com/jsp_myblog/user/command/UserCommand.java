package com.jsp_myblog.user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserCommand {
	String execute(HttpServletRequest request, HttpServletResponse response);
}
