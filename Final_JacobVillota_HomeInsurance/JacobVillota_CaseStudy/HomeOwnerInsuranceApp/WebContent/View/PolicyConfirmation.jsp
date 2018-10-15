<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!doctype HTML5>
<html>
<title>Policy Confirmation</title>
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
				<font size="3">Policy Confirmation 
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
							<br>
							<br> <img
								src="C:\Users\Student\Desktop\QE02\casestudyexternalfiles\casestudytwostory.png"
								height="150" width="200">
					</div>
					<div>
						<br> <br> <br> <b> Our customer service
							representitive will contact you shortly for premium collection
							arrangements.</b><br>
						<br>
						<table align="left">
							<tr>
								<td>Quote Id<require></require></td>
								<td><c:out value="${quote.getQuote_ID()}"/></td>
							</tr>
							<tr>
								<td>Policy Key</td>
								<td><c:out value="${Po.getPolicy_Id()}"/></td>
							</tr>
							<tr>
								<td>Policy Effective Date</td>
								<td><c:out value="${Po.getStart_date()}"/></td>
							</tr>
							<tr>
								<td>Policy End Date</td>
								<td><c:out value="${Po.getEnd_Date()}"/></td>
							</tr>
							<tr>
								<td>Policy Term</td>
								<td><c:out value="${Po.getTerm()}"/></td>
							</tr>
							<tr>
								<td>Policy Status</td>
								<td><c:out value="${Po.getStatus()}"/></td>
							</tr>
						</table>
					</div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<hr>
				<center>Copyright © 2018 HomeownerInsurance.com All Rights
					Reserved</center>