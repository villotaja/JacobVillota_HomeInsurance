<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype HTML5>
<html>
<title>Coverage Details</title>
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
				<font size="3">Coverage Details 
			</H2>
			<style>
* {
	box-sizing: border-box;
}

.column {
	float: left;
	width: 55%;
	padding: 20px;
	height: 250px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
			</head>
			<body>
				<div class="row">
					<div class="column">
						<center>
							<br> <br> <img
								src="C:\Users\Student\Desktop\QE02\casestudyexternalfiles\casestudytwostory.png"
								height="150" width="200">
					</div>
					<div>
						<br> <br> <br>
						
						<form action="../View/QuoteDetails.jsp" method="get">
						<table align="left">
							<tr>
								<td></td>
								<td><a href="../View/AddInfo.jsp"> Additional Info </a>
							<tr>
								<td>Quote Id</td>
								<td><c:out value="${quote.getQuote_ID()}"/></td>
							</tr>
							<tr>
								<td>Monthly Premium</td>
								<td>$<c:out value="${quote.getMonthly_Premium()}"/></td>
							</tr>
							<tr>
								<td>Dwelling Coverage</td>
								<td>$<c:out value="${quote.getDwelling_Coverage()}"/></td>
							</tr>
							<tr>
								<td>Detached Structures</td>
								<td>$<c:out value="${quote.getDetached_Structures()}"/></td>
							</tr>
							<tr>
								<td>Personal Property</td>
								<td>$<c:out value="${quote.getPersonal_Property()}"/></td>
							</tr>
							<tr>
								<td>Additional living expense</td>
								<td>$<c:out value="${quote.getAdditional_Living_EXP()}"/></td>
							</tr>
							<tr>
								<td>Medical Expense</td>
								<td>$<c:out value="${quote.getMed_Exp()}"/></td>
							</tr>
							<tr>
								<td>Deductible</td>
								<td>$<c:out value="${quote.getDeductible()}"/></td>
							</tr>
							<tr></tr><td></td><td><input type="Submit" value="Proceed to Buy"></td>
						</table>
						</form>
					</div>
				</div><br><br><br><br>
				<hr>
				<center>Copyright © 2018 HomeownerInsurance.com All Rights
					Reserved</center>