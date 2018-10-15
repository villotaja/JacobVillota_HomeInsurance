<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype HTML5>
<html>
<title>Get Quote</title>
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
				<font size="3">Get Quote 
			</H2>
			<style>
* {
	box-sizing: border-box;
}

.column {
	float: left;
	width: 65%;
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
						<form action="NewQuote" method="post">
							<table align="left">
								<tr>
									<td>Residence Type<font color="red"> *</font> <require></require></td>
									<td><select name="rt">
											<option value="single">Single-Family Home</option>
											<option value="condo">Condo</option>
											<option value="Duplex">Duplex</option>
											<option value="Apartment">Apartment</option>
											<option value="Townhouse">Townhouse</option>
											<option value="Rowhouse">Rowhouse</option>
									</select></td>
								</tr>

								<tr>
									<td>Address Line 1<font color="red"> *</font></td>
									<td><input type="text" name="add1" required></td>
									<font color="red"> ${NullAddress} </font>
								</tr>

								<tr>
									<td>Address Line 2</td>
									<td><input type="text" name="add2"></td>
								</tr>

								<tr>
									<td>State<font color="red"> *</font>
									</td>
									<td><input type="text" name="state" required><font
										color="red"> ${NullSt} </font></td>
								</tr>
								<tr>
									<td>City<font color="red"> *</font>
									</td>

									<td><input type="text" name="City" required><font
										color="red"> ${NullCt} </font></td>
								</tr>
								<tr>
									<td>Zip<font color="red"> *</font>
									</td>

									<td><input type="text" name="Zip" required><font
										color="red"> ${NullZip} </font></td>
								</tr>
								<tr>
									<td>Residence Use<font color="red"> *</font></td>
									<td><select name="RU">
											<option value="Primary">Primary</option>
											<option value="Secondary">Secondary</option>
											<option value="Rental">Rental Property</option>
									</select></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Continue" name="go on"></td>
								</tr>

							</table>
						</form>
					</div>
				</div>
				<hr>
				<center>Copyright © 2018 HomeownerInsurance.com All Rights
					Reserved</center>
<%session.removeAttribute("NullAddress");
  session.removeAttribute("NullSt");
  session.removeAttribute("NullCt");
  session.removeAttribute("NullZip");%>
			</body>
</html>