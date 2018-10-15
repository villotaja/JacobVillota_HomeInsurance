<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>Available Policies</title>
<HEAD>
<body style="background-color: lightyellow;">
	<STYLE type="text/css">
H1 {
	text-align: center;
	color: #883f0a;
}

H2 {
	text-align: center;
	color: #883f0a;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table th {
	background-color: #883f0a;
	color: white;
}
</STYLE>
	<H1>
		<img
			src="C:\Users\Student\Desktop\QE02\casestudyexternalfiles\homepicture.jpg"
			height="50" width="50"> <font size="6"> Homeowner
			Insurance 
	</H1>
	<center>
				<font size="4"> <a href="Home.jsp"> Home</a> | <a
			href="GetQuote.jsp"> Get Quote</a> | <a href="QuoteDetails">
				Retrieve Quote</a> | <a href="AllPolicies"> My Policies</a>|
			<a href="Logout"> Logout</a><br>
			<hr>
			<H2>
				<font size="3">Current Policies 
			</H2>
			<table align="center">
			<form action="../View/AllPolicies" method="get">
				<table style="width: 100%">
					<tr>
						<th>Policy<br> Key
						</th>
						<th>Quote<br> Id
						</th>
						<th>Policy Effective<br> Date
						</th>
						<th>Policy End <br> Date
						</th>
						<th>Policy<br> Term
						</th>
						<th>Policy<br> Status
						</th>
						<th>Renew<br> Policy
						</th>
						<th>Cancel<br> Policy
						</th>
					</tr>
	<c:forEach items="${PO.keySet()}" var="policy_Id">
					<tr>
<td><c:out value="${PO.getPolicy_Id()}"/></td>
<td><c:out value="${PO.getQuotes_Quote_ID()}"/></td>
<td> <c:out value="${PO.getStart_date()}"/> </td>
<td> <c:out value="${PO.getEnd_Date()}"/></td>
<td> <c:out value="${PO.getStatus()}"/></td>
<td> <c:out value="${PO.getTerm()}"/></td>
<td> coming soon *</td>
<td> coming soon *</td>
					</tr>
	</c:forEach>
				</table></form>
			</table> <br> <br>
			<center> <b>*These features will be implemented in later if you have any questions feel free to contact customer support</b></center>
		<br>
		<br>
			<hr>
			<center>Copyright © 2018 HomeownerInsurance.com All Rights
				Reserved</center>
</html>