<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
		"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>
			Editing Contact
		</title>
		<table align="left">
		<tr>
			<tr><td><img src="view/Home.jpg"/></td>
			
		</tr>
		</table>
		<table align="right">
		<tr>
			<td><a href="view/home.jsp">Home</a></td>
			<td><a href="LogoutServlet">Logout</a></td>
		</tr>
	</table>
	</head>
	<c:forEach var="contacts" items="${contactList}">
	<body bgcolor="#FFEBCD">
		<form action="EditContact?contactid=${contacts.contactid}">
		
			<table cellpadding="2" width="40%"  align="center" cellspacing="2" >
				<tr>
					<td align="center" colspan="2"><font size="4">Edit Contact</td>
				</tr>
				<tr>
					<td><font size="4">Contact Id:</td>
					<td><input type="text" name="contactid" value="${contacts.contactid}"/>
				</tr>
				<tr>
					<td><font size="4">First Name:</td>
					<td><input type="text" name="firstname" value="${contacts.firstname}"/>
				</tr>
				<tr>
					<td><font size="4">Last Name:</td>
					<td><input type="text" name="lastname" value="${contacts.lastname}"/></td>
				</tr>
				<tr>
					<td><font size="4">Designation:</td>
					<td><input type="text" name="designation" value="${contacts.designation}"/></td>
				</tr>
				<tr>
					<td><font size="4">Email:</td>
					<td><input type="text" name="email" value="${contacts.email}"/></td>
				</tr>
				
				<tr>
					<td><font size="4">City:</td>
					<td><input type="text" name="city" value="${contacts.city}"/></td>
				</tr>
				<tr>
					<td><font size="4">Company:</td>
					<td><input type="text" name="company" value="${contacts.company}"/></td>
				</tr>
				<tr>
					<td><font size="4">PhoneNo:</td>
					<td><input type="text" name="phoneno" value="${contacts.phoneno}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save"/><input type="reset" value="clear"/></td>
				</tr>
			</table>
		</form>
	</body>
	</c:forEach>
</html>