<html>
	<head>
		<title>
			Add Contact
		</title>
		<table align="left">
		<tr>
		<td><img src="Home.jpg"/></td>
		</tr>
		</table>
		<table align="right">
		<tr>
			<td><a href="home.jsp">Home</a></td>
			<td><a href="../LogoutServlet">Logout</a></td>
		</tr>
	</table>
	</head>
	<body bgcolor="#FFEBCD">
		<form action="../AddContact">
		
			<table cellpadding="2" width="40%"  align="center" cellspacing="2" >
				<tr>
					<td align="center" colspan="2"><font size="4">Adding Contact</td>
				</tr>
				<tr>
					<td><font size="4">First Name:</td>
					<td><input type="text" name="firstname"/>
				</tr>
				<tr>
					<td><font size="4">Last Name:</td>
					<td><input type="text" name="lastname"/></td>
				</tr>
				<tr>
					<td><font size="4">Designation:</td>
					<td><input type="text" name="designation"/></td>
				</tr>
				<tr>
					<td><font size="4">Email:</td>
					<td><input type="text" name="email"/></td>
				</tr>
				
				<tr>
					<td><font size="4">City:</td>
					<td><input type="text" name="city"/></td>
				</tr>
				<tr>
					<td><font size="4">Company:</td>
					<td><input type="text" name="company"/></td>
				</tr>
				<tr>
					<td><font size="4">PhoneNo:</td>
					<td><input type="text" name="phoneno"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="save"/><input type="reset" value="clear"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>