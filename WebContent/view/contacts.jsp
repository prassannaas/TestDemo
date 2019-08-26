<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
		"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>
			Contacts
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
	
	<body bgcolor="#FFEBCD"><font size="4">
	<table align="center">
		<tr>
			<td><img src="view/contacts_256.png" height="128" width="128"/></td>
			<td><font size="15">CONTACTS</td>
		</tr>
	</table>
	<table align="center">
	<tr>

			<td><a href="view/addcontact.jsp">Add</a></td>
		
	<form action="SearchContactsServlet">
		
		
			<td><input type="text" name="search"></td>
			<td><input type="submit" value="Search"/></td>
		</tr>	
	</table>
	</form>
	
	
	
	
	<table border="1" cellpadding="3" cellspacing="0" align="center">
		<tr>
				<th>Contact Id</th>
				<TH>First Name</TH>
                <TH>Last Name</TH>
                <TH>Designation</TH>
                <TH>Email</TH>
                <TH>City</TH>
                <TH>Company</TH>
                <TH>PhoneNo</TH>
                <th></th>
		</tr>
	
	<c:forEach var="contacts" items="${contactList}">
			<tr>
				<td>${contacts.contactid}</td>
				<td>${contacts.firstname}</td>
				<td>${contacts.lastname}</td>
				<td>${contacts.designation}</td>
				<td>${contacts.email}</td>
				<td>${contacts.city}</td>
				<td>${contacts.company}</td>
				<td>${contacts.phoneno}</td>
				<td>
					<a href="ConvoServlet?contactid=${contacts.contactid}&firstname=${contacts.firstname}"><img src="view/convo.jpg"></a>
					<a href="GetContact?contactid=${contacts.contactid}"><img src="view/edit.ico"></a>
					<a href="DeleteContact?contactid=${contacts.contactid}"><img src="view/Delete.png"></a>
					
				</td>
			</tr>
		</c:forEach>
	</table>

	<%--For displaying Previous link except for the 1st page --%>
	<table align="center" border="0" cellpadding="5" cellspacing="0" width="50">
	<c:if test="${currentPage != 1}">
		<tr>
		<td><a href="ContactsServlet?page=${currentPage - 1}">Previous</a></td>
	</c:if>

	<%--For displaying Page numbers. 
	The when condition does not display a link for the current page--%>
	
		
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<td>${i}</td>
					</c:when>
					<c:otherwise>
						<td><a href="ContactsServlet?page=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		

	
	<%--For displaying Next link --%>
	<c:if test="${currentPage lt noOfPages}">
		<td><a href="ContactsServlet?page=${currentPage + 1}">Next</a></td>
	</c:if>
	</tr>
</table>
</font>	</body>
</html>