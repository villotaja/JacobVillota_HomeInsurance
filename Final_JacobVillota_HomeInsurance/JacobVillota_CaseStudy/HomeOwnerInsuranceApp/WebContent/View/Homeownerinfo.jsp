<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype HTML5>
<html>
<title>Homeowner Information</title>
<HEAD>
<body style="background-color: lightyellow;">
	<TITLE>Homeowner Information</TITLE>
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
				<font size="3">Homeowner Information 
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
						<br> <br> <br> <font color="red"> ${Blank}</font>
						<form action="HomeInfo" method="get">
							<table align="left">
								<tr>
									<td><label class="req">First name</label><font color="red">*</font></td>
									<td><input type="text" name="Fname" required><font color="red"> ${Fname}</font></td>
								</tr>
								<tr>
									<td>Last Name<font color="red"> *</font></td>
									<td><input type="text" name="Lname" required><font color="red"> ${Lname}</font></td>
								</tr>
								<tr>
									<td>Date of Birth<font color="red"> *</font></td>
									<td><input id="date" name="birthday"
										placeholder="yyyy-MM-dd" required> <font color="red"> ${Bday} </font></td>
								</tr>
								<tr>
									<td>Are you retired?<font color="red"> *</font>
									</td>
									<td><label><input type="radio" name="retired"
											value="true" required> Yes</label><label> <input
											type="radio" name="retired" value="false"> No
									</label></td>
								</tr>
								<tr>
									<td>Social Security Number<font color="red"> *</font>
									</td>
									<td><input type="text" name="SSN"
										placeholder="enter 9 digits for SSN" required> <font color="red"> ${SSN} </font></td>
								</tr>
								<tr>
									<td>Email Address<font color="red"> *</font>
									</td>
									<td><input type="text" name="Email" required><font color="red"> ${Email} </font></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Continue"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<hr>
				<center>Copyright © 2018 HomeownerInsurance.com All Rights
					Reserved</center>
					<%session.removeAttribute("Fname"); %>
					<%session.removeAttribute("Lname"); %>
					<%session.removeAttribute("SSN"); %>
					<%session.removeAttribute("Email"); %>
					<%session.removeAttribute("Bday"); %>
</html>