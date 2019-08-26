<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
		"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>
			Add Opportunity
		</title>
		<table align="left">
		<tr>
		<td><img src="view/Home.jpg"/></td>
		</tr>
		</table>
		<table align="right">
		<tr>
		<td><a href="view/home.jsp">Home</a></td>
			<td><a href="LogoutServlet">Logout</a></td>
		</tr>
	</table>
	</head>
	<body bgcolor="#FFEBCD">
		<form action="AddOpportunityServlet">
		
			<table cellpadding="2" width="40%"  align="center" cellspacing="2" >
				<tr>
					<td align="center" colspan="2"><font size="4">Adding Opportunity</td>
				</tr>
				<tr>
					<td><font size="4">Subject:</td>
					<td><input type="text" name="subject"/></td>
				</tr>
				<tr>
					<td><font size="4">Account:</td>
					<td>
					<SELECT name="account">
					<c:forEach var="accounts" items="${accountstList}">
					
					
				<option>${accounts.name}</option>
				
				
				</c:forEach>
				</SELECT>
				</td>
		
						
						
						
						
						
					
				</tr>
				<tr>
					<td><font size="4">Type:</td>
					<td>
						<SELECT name="type">
							<OPTION>Select</OPTION>
							<OPTION value="AppDevelopment">Consultancy</OPTION>
							<OPTION value="AppTesting">Software</OPTION>
							<OPTION value="Design">Design</OPTION>
							<OPTION value="Implimentation">Insurance</OPTION>
							
						 </SELECT>
					</td>
				</tr>
				<tr>
					<td><font size="4">Status:</td>
					<td>
						<SELECT name="status">
							<OPTION value="new">new</OPTION>
							<OPTION value="closedown">closedown</OPTION>
							<OPTION value="closelast">closelast</OPTION>
							<OPTION value="ongoing">ongoing</OPTION>
							<OPTION value="ready2delivery">ready2delivery</OPTION>
						</SELECT>
					</td>
				</tr>
				<tr>
					<td><font size="4">Probability:</td>
					<td><input type="text" name="probability"/></td>
				</tr>
				<tr>
					<td><font size="4">Notes:</td>
					<td><textarea rows="3" cols="17" name="notes"></textarea></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="save"/><input type="reset" value="clear"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>