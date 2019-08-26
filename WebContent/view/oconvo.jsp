<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
		"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>
			Opportunity Convo
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
			
			<td><font size="10"><b>CONVO</b></font></td>
			<td>  with  ${subject}</td>
		</tr>
	</table>
	
			
		
		
	<form action="OConvoServlet">
		
		<table align="center">
		<tr>
			<td></td>
			<td><input type="hidden" name="opportunityid" value="${opportunityid }"></td>
			<td><input type="hidden" name="subject" value="${subject }"></td>	
		</tr>
		<tr>
				<td><font size="4">Convo Mode:</td>
				<td>
					<SELECT name="convo">
							<OPTION>Select</OPTION>
							<OPTION value="phone">Phone</OPTION>
							<OPTION value="email">Email      </OPTION>
							<OPTION value="inperson">In-Person	</OPTION>
							<OPTION value="im">IM</OPTION>
						 </SELECT>
				</td>
		</tr>
		<tr>
			<td><font size="4">Details:</td>
			<td><textarea rows="3" cols="17" name="details"></textarea></td>
				
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="submit"><input type="reset" value="clear"/></td>
		</tr>	
	
	</form>
	</table>
	<table  border="1" cellpadding="3" cellspacing="0" align="center">
		<tr>
				<th>Date and Time</th>
				<TH>Convo</TH>
                <TH>Details</TH>
               
		</tr>
	
	<c:forEach var="oconvo" items="${oconvoList}">
			<tr>
				
				<td>${oconvo.datetime}</td>
				<td>${oconvo.convo}</td>
				<td>${oconvo.details}</td>
				</tr>
		</c:forEach>
	</table>

<%-- 	For displaying Previous link except for the 1st page --%> 
<!-- 	<table border="0" cellpadding="5" cellspacing="0" width="50" align="center"> -->
<!-- 		<tr> -->
<%-- 	<c:if test="${currentPage != 1}"> --%>
<%-- 		<td><a href="ConvoServlet?page=${currentPage - 1}">Previous</a></td> --%>
<%-- 	</c:if> --%>

<%-- 	<%--For displaying Page numbers.  --%>
<%-- 	The when condition does not display a link for the current page--%>
	
<%-- 			<c:forEach begin="1" end="${noOfPages}" var="i"> --%>
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${currentPage eq i}"> --%>
<%-- 						<td>${i}</td> --%>
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<%-- 						<td><a href="ConvoServlet?page=${i}">${i}</a></td> --%>
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
<%-- 			</c:forEach> --%>
	
	
<%-- 	<%--For displaying Next link --%> 
<%-- 	<c:if test="${currentPage lt noOfPages}"> --%>
<%-- 		<td><a href="ConvoServlet?page=${currentPage + 1}">Next</a></td> --%>
<%-- 	</c:if> --%>
<!-- 		</tr> -->
<!-- 	</table> -->
	</font></body>
</html>