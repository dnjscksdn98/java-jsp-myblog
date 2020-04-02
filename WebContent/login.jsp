<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Login</title>
	</head>
	<body>
		<h2>Login</h2>
		<form action="login.user" method="post">
			ID : <input type="text" name="id"> <br />
			Password : <input type="password" name="password"><br />
			<input type="submit" value="login">
		</form>
		You don't have an account? <a href="signup_view.user">Signup</a>
	</body>
</html>