<html>
	<head>
		<title>
			Add Account
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
		<form action="../AddAccountServlet">
		
			<table cellpadding="2" width="40%"  align="center" cellspacing="2" >
				<tr>
					<td align="center" colspan="2"><font size="4">Adding Account</td>
				</tr>
				
				<tr>
					<td><font size="4">Name:</td>
					<td><input type="text" name="name"/>
				</tr>
				<tr>
					<td><font size="4">Website:</td>
					<td><input type="text" name="website"/></td>
				</tr>
				<tr>
					<td><font size="4">City:</td>
					<td><input type="text" name="city"/></td>
				</tr>
				<tr>
					<td><font size="4">Board_Phno:</td>
					<td><input type="text" name="boardphno"/></td>
				</tr>
				<tr>
					<td><font size="4">Industry:</td>
					<td>
						<SELECT name="industry">
							<OPTION>Select</OPTION>
							<OPTION value="Consultancy">Consultancy</OPTION>
							<OPTION value="Software">Software</OPTION>
							<OPTION value="Hardware">Hardware</OPTION>
							<OPTION value="Insurance">Insurance</OPTION>
							<OPTION value="Retail">Retail</OPTION>
							<OPTION value="Education">Education</OPTION>
							<OPTION value="Services">Services</OPTION>
						 </SELECT>
					</td>
				</tr>
				<tr>
					<td><font size="4">No.of Employees:</td>
					<td><input type="text" name="employees"/></td>
				</tr>
				<tr>
					<td><font size="4">Branches:</td>
					<td><input type="text" name="branches"/></td>
				</tr>
				<tr>
					<td><font size="4">Revenue:</td>
					<td><input type="text" name="revenue"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="save"/><input type="reset" value="clear"/></td>
				</tr>
			</table>
		</form>
		
	</body>
</html>