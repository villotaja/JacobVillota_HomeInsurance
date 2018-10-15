<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>Quote Details</title>
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
				<font size="3">Quote Details 
			</H2>
			<table align="center">
				<table style="width: 100%">
					<tr>
						<th>QuoteId</th>
						<th>Residence Type</th>
						<th>Address</th>
						<th>City</th>
						<th>State</th>
						<th>Zip</th>
						<th>Residence Use</th>
						<th>Status</th>
						<th>Rest of information</th>
					</tr>
					<c:forEach items="${info.keySet()}" var="quoteId">
						<tr>
							<td><c:out value="${quoteId}" /></td>
							<td><c:out value="${info.get(quoteId).getResidence_type()}" /></td>
							<td><c:out value="${info.get(quoteId).getAddress_line_1()}" /></td>
							<td><c:out value="${info.get(quoteId).getCity()}" /></td>
							<td><c:out value="${info.get(quoteId).getLocation_state()}" /></td>
							<td><c:out value="${info.get(quoteId).getZipcode()}" /></td>
							<td><c:out value="${info.get(quoteId).getResidence_use()}" /></td>
							<td>New</td>
							<td><a href="../View/QuoteSummary?quoteId=${quoteId}"> Click</a></td>
						</tr>
					</c:forEach>
				</table>
			</table> <br> <br> <br> <br>
			<hr>
			<center>Copyright © 2018 HomeownerInsurance.com All Rights
				Reserved</center>
</html>