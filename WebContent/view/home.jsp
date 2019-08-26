<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<head>
		<base href="<%=basePath%>" />
		<title>Home Page</title>
	</head>
	<table align="right">
		<tr>
			<td><a href="LogoutServlet">Logout</a></td>
		</tr>
	</table>
	<font size="7">
	<body bgcolor="#FFEBCD">
		
		<pre>
			
			<table  width="70%" valign="middle" cellspacing="0" align="center"  border="0" >
			<tr>
				<td align="center"><img src="view/Home.jpg"/></td>
				
			</tr>
			<tr><td>&nbsp</td><td>&nbsp</td></tr>
			<tr><td>&nbsp</td><td>&nbsp</td></tr>
			<tr><td>&nbsp</td><td>&nbsp</td></tr>
			<tr>
				<td align="center"><a href="ContactsServlet?page=1"><font size="9"><b>Contacts</b></font></a>
			</tr>
			<tr>
			<td align="center"><a href="OpportunityServlet?page=1"><font size="9"><b>Opportunities</b></font></a></td>
			</tr>
			<tr>
				<td align="center"><a href="AccountsServlet?page=1"><font size="9"><b>Accounts</b></font></a></td>
			</tr>
			<tr>
			<td align="center"><a href="view/quotes.jsp"><font size="9"><b>Quotes</b></font></a></td>
			</tr>
		</table>
	
		</pre>
	</body>
	
</html>