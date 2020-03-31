<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Home</title>
	</head>
	<body>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>#</td>
				<td>writer</td>
				<td>title</td>
				<td>registered date</td>
				<td>views</td>
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.getId()}</td>
					<td>${dto.getWriter()}</td>
					<td><a href="detail_view.do?id=${dto.getId()}">${dto.getTitle()}</a></td>
					<td>${dto.getRDate()}</td>
					<td>${dto.getViews()}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"> <a href="write_view.do">write article</a> </td>
			</tr>
		</table>
	</body>
</html>