<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
		"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<head>
		<base href="<%=basePath%>" />
		<title>
			Accounts
		</title>
		<table align="left">
		<tr>
			<td><img src="view/Home.jpg"/></td>
			
		</tr>
		<table align="right">
		<tr>
		<td><a href="view/home.jsp">Home</a></td>
			<td><a href="LogoutServlet">Logout</a></td>
		</tr>
	</table>
	</head>
	<body bgcolor="#FFEBCD" ><font size="4">
	<table align="center">
		<tr>
			<td><img src="view/accounts_256.png" height="128" width="128"/></td>
			<td><font size="15"><b>ACCOUNTS</b></font></td>
		</tr>
	</table>
	<table align="center">
		<tr>
			<td><a href="view/addaccount.jsp">Add</a></td>
		
		
	<form action="SearchAccountsServlet">
		
		
			<td><input type="text" name="search"></td>
			<td><input type="submit" value="Search"/></td>
		</tr>	
	
	</form>
	</table>
	<table border="1" cellpadding="3" cellspacing="0" align="center">
		<tr>
				<th>Account ID</th>
				<TH>Name</TH>
                <TH>Website</TH>
                <TH>City</TH>
                <TH>BoardPhno</TH>
                <TH>Industry</TH>
                <TH>NoofEmployees</TH>
                <TH>Branches</TH>
                <TH>Revenue</TH>
                <th></th>
		</tr>
	
	<c:forEach var="accounts" items="${accountstList}">
			<tr>
				<td>${accounts.accountid}</td>
				<td>${accounts.name}</td>
				<td>${accounts.website}</td>
				<td>${accounts.city}</td>
				<td>${accounts.boardphno}</td>
				<td>${accounts.industry}</td>
				<td>${accounts.noofemployees}</td>
				<td>${accounts.branches}</td>
				<td>${accounts.revenue}</td>
				<td><a href="GetAccount?accountid=${accounts.accountid}&name=${accounts.name}"><img src="view/edit.ico"></a>
				<a href="DeleteAccount?accountid=${accounts.accountid}"><img src="view/Delete.png"></a></td>
				
			</tr>
		</c:forEach>
	</table>

	<%--For displaying Previous link except for the 1st page --%>
	<table border="0" cellpadding="5" cellspacing="0" width="50" align="center">
		<tr>
	<c:if test="${currentPage != 1}">
		<td><a href="AccountsServlet?page=${currentPage - 1}">Previous</a></td>
	</c:if>

	<%--For displaying Page numbers. 
	The when condition does not display a link for the current page--%>
	
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<td>${i}</td>
					</c:when>
					<c:otherwise>
						<td><a href="AccountsServlet?page=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	
	
	<%--For displaying Next link --%>
	<c:if test="${currentPage lt noOfPages}">
		<td><a href="AccountsServlet?page=${currentPage + 1}">Next</a></td>
	</c:if>
		</tr>
	</table>
	</font></body>
</html>