<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Signup</title>
		<script src="users.js"></script>
	</head>
	<body>
		<h2>Signup</h2>
		<form action="signup.user" method="post" name="signupForm">
			ID : <input type="text" name="id" size="20" /><br />
			Password : <input type="password" name="password" size="20" /><br />
			Confirm Password : <input type="password" name="confirmPassword" size="20" /><br />
			Name : <input type="text" name="name" size="20" /><br />
			Email : <input type="email" name="email" size="30" /><br />
			<input type="button" value="signup" onclick="infoConfirm()" />
		</form>
		You already have an account ? <a href="login_view.user">Login</a>
	</body>
</html>