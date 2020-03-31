<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>${detail_view.getTitle()}</title>
	</head>
	<body>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<form action="update.do" method="post">
				<input type="hidden" name="id" value="${detail_view.getId()}">
				<tr>
					<td> # </td>
					<td> ${detail_view.getId()} </td>
				</tr>
				<tr>
					<td> views </td>
					<td> ${detail_view.getViews()} </td>
				</tr>
				<tr>
					<td> writer </td>
					<td> <input type="text" name="writer" value="${detail_view.getWriter()}"></td>
				</tr>
				<tr>
					<td> title </td>
					<td> <input type="text" name="title" value="${detail_view.getTitle()}"></td>
				</tr>
				<tr>
					<td> content </td>
					<td> <textarea rows="10" name="content" >${detail_view.getContent()}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"> 
						<input type="submit" value="update"> &nbsp;&nbsp; 
						<a href="list.do">articles</a> &nbsp;&nbsp; 
						<a href="delete.do?id=${detail_view.getId()}">delete</a> &nbsp;&nbsp; 
						<a href="reply_view.do?id=${detail_view.getId()}">reply</a>
					</td>
				</tr>
			</form>
		</table>
	</body>
</html>