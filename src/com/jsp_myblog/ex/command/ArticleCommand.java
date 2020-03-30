package com.jsp_myblog.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ArticleCommand {

	void execute(HttpServletRequest request, HttpServletResponse response);
}
