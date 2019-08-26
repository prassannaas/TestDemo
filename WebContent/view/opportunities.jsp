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
			Opportunities
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
	<body bgcolor="#FFEBCD"><font size="4">
	<table align="center">
		<tr>
			<td><img src="view/opportunity_256.png" height="128" width="128"/></td>
			<td><font size="10">OPPORTUNITIES</td>
		</tr>
	</table>
	<table align="center">
		<tr>
		<td><a href="AccServlet">Add</a></td>
		<form action="SearchOpportunitiesServlet">
		
			<td><input type="text" name="search"></td>
			<td><input type="submit" value="Search"/></td>
		</tr>	
	</table>
	</form>
	<table border="1" cellpadding="3" cellspacing="0" align="center">
		<tr>
				<th>Opportunilty Id</th>
				<TH>Subject</TH>
                <TH>Account</TH>
                <TH>Type</TH>
                <TH>Status</TH>
                <TH>Probability</TH>
                <TH>Notes</TH>
                <th></th>
        </tr>
	
	<c:forEach var="opportunities" items="${opportunitiesList}">
			<tr>
				<td>${opportunities.opportunityid}</td>
				<td>${opportunities.subject}</td>
				<td>${opportunities.account}</td>
				<td>${opportunities.type}</td>
				<td>${opportunities.status}</td>
				<td>${opportunities.probability}</td>
				<td>${opportunities.notes}</td>
				<td><a href="OConvoServlet?opportunityid=${opportunities.opportunityid}&subject=${opportunities.subject}"><img src="view/convo.jpg"></a>
					<a href="GetOpportunity?opportunityid=${opportunities.opportunityid}&subject=${opportunities.subject}"><img src="view/edit.ico"></a>
					<a href="DeleteOpportunity?opportunityid=${opportunities.opportunityid}"><img src="view/Delete.png"></a></td>
				
			</tr>
		</c:forEach>
	</table>

	<%--For displaying Previous link except for the 1st page --%>
	<table align="center" border="0" cellpadding="5" cellspacing="0" width="50">
	<c:if test="${currentPage != 1}">
	<tr>	<td><a href="OpportunityServlet?page=${currentPage - 1}">Previous</a></td>
	</c:if>

	<%--For displaying Page numbers. 
	The when condition does not display a link for the current page--%>
	
		
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<td>${i}</td>
					</c:when>
					<c:otherwise>
						<td><a href="OpportunityServlet?page=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		
	
	
	<%--For displaying Next link --%>
	<c:if test="${currentPage lt noOfPages}">
		<td><a href="OpportunityServlet?page=${currentPage + 1}">Next</a></td>
	</c:if></tr>
	</table>
	</font>
	</body>
</html>