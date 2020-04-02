<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%
	if(session.getAttribute("userid") == null) {
%>
		<jsp:forward page="login_view.user" />
<%
	}
%>

<html>
	<head>
		<meta charset="EUC-KR">
		<title>Write a new article</title>
	</head>
	<body>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<form action="write.do" method="post">
				<tr>
					<td>Writer</td>
					<td><input type="text" name="writer" size="50" value="<% out.println(session.getAttribute("username")); %>"></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" size ="100"></td>
				</tr>
				<tr>
					<td>Content</td>
					<td><textarea name="content" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Write"> &nbsp;&nbsp; <a href="list.do">Articles</a></td>
				</tr>
			</form>
		</table>
	</body>
</html>