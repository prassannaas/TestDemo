<html>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<head>
		<base href="<%=basePath%>" />
		<title>LoginPage</title>
	</head>
	<body bgcolor="#FFEBCD">
		<form action="LoginServlet">
			<table  align="center">
			<tr><th>Login Page</th></tr>
			<tr><td>UserId</td><td><input type="text" name="userid"/></td></tr>
			<tr><td>Password</td><td><input type="password" name="password"/></td></tr>
			<tr><td><input type="submit" value="login"/></td><td><input type="reset" value="clear"/></td>
		</table>
		</form>
	</body>
</html>