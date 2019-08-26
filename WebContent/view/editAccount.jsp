<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
		"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>
			Edit Account
		</title>
		<table align="left">
		<tr>
			<tr><td><img src="view/Home.jpg"/></td>
			
		</tr>
		<table align="right">
		<tr>
		<td><a href="view/home.jsp">Home</a></td>
			<td><a href="LogoutServlet">Logout</a></td>
		</tr>
	</table>
	</head>
	<c:forEach var="accounts" items="${accountstList}">
	<body bgcolor="#FFEBCD">
		<form action="./EditAccount?accountid=${accounts.accountid}">
		
			<table cellpadding="2" width="40%"  align="center" cellspacing="2" >
				
				<tr>
					<td align="center" colspan="2"><font size="4">Edit Account</td>
				</tr>
				<tr>
					<td><font size="4">Account Id:</td>
					<td><input type="text" name="accountid" value="${accounts.accountid}"/>
				</tr>
				<tr>
					<td><font size="4">Name:</td>
					<td><input type="text" name="name" value="${accounts.name}"/>
				</tr>
				<tr>
					<td><font size="4">Website:</td>
					<td><input type="text" name="website" value="${accounts.website}"/></td>
				</tr>
				<tr>
					<td><font size="4">City:</td>
					<td><input type="text" name="city" value="${accounts.city}"/></td>
				</tr>
				<tr>
					<td><font size="4">Board_Phno:</td>
					<td><input type="text" name="boardphno" value="${accounts.boardphno}"/></td>
				</tr>
				<tr>
					<td><font size="4">Industry:</td>
					<td>
						<SELECT name="industry" value="${accounts.industry}">
							
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
					<td><input type="text" name="employees" value="${accounts.noofemployees}"/></td>
				</tr>
				<tr>
					<td><font size="4">Branches:</td>
					<td><input type="text" name="branches" value="${accounts.branches}"/></td>
				</tr>
				<tr>
					<td><font size="4">Revenue:</td>
					<td><input type="text" name="revenue" value="${accounts.revenue}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save"/><input type="reset" value="Clear"/></td>
				</tr>
			
			</table>
		</form>
	</body>
	</c:forEach>
</html>