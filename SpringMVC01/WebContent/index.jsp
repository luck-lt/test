<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="static/js/out.js"></script>
<link href="css/main.css" type="text/css" rel="stylesheet">
</head>
<body>
	<a href="my">my</a>
	<br>
	<a href="hello?sid=&user=admin">hello</a>

	<form action="login.action" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input name=username></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
	<form action="success.action" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input name=username></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
	<input type="image" src="static/image/submit.gif">
</body>
</html>