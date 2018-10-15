<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype HTML5>
<html>
<title>Property Details</title>
<HEAD>
<body style="background-color: lightyellow;">
	<style type="text/css">
H1 {
	text-align: center;
	color: #883f0a;
}

H2 {
	text-align: center;
	color: #883f0a;
}

req {
	
}
</style>
	<h1>
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
				<font size="3">Property Details <br><font color="red"> ${Blank} </font> 
			</H2>
			<form action="Propdets" method="get">
				<table align="center">
					<tr>
						<td>What is the market Value of your home?<font color="red">
								*</font> &nbsp $
						</td>
						<td><input type="text" name="mrktvalue" required></td>
					</tr>
					<tr>
						<td>What year was your home originally built?<font
							color="red"> *</font></td>
						<td><input type="text" name="yearblt" required></td>
					</tr>
					<tr>
						<td>Square footage<font color="red"> *</font>
						</td>
						<td><input type="text" name="sqft" required> sqft</td>
					</tr>
					<tr>
						<td>Dwelling Style<font color="red"> *</font></td>
						<td><select name="DS">
								<option value="onestory">1 Story</option>
								<option value="halfstory">1.5 Stories</option>
								<option value="twostory">2 Stories</option>
								<option value="twohalfstory">2.5 Stories</option>
								<option value="threestory">3 Stories</option>
						</select></td>
					</tr>
					<tr>
						<td>Roof Material<font color="red"> *</font></td>
						<td><select name="RM">
								<option value="Concrete">Concrete</option>
								<option value="Clay">Clay</option>
								<option value="Rubber">Rubber</option>
								<option value="Steel">Steel</option>
								<option value="Tin">Tin</option>
								<option value="Wood">Wood</option>
						</select></td>
					</tr>
					<tr>
						<td>Type of Garage<font color="red"> *</font></td>
						<td><select name="Garage">
								<option value="Attached">Attached</option>
								<option value="Detached">Detached</option>
								<option value="Basement">Basement</option>
								<option value="Built-in">Built-in</option>
								<option value="None">None</option>
						</select></td>
					</tr>
					<tr>
						<td>Number of full baths<font color="red" required> *</font></td>
						<td><select name="Fullbath">
								<option value=1>1</option>
								<option value=2>2</option>
								<option value=3>3 or more</option>
						</select></td>
					</tr>
					<tr>
						<td>Number of half baths<font color="red" required> *</font>
						</td>
						<td><select name="HalfBath">
								<option value=1>1</option>
								<option value=2>2</option>
								<option value=3>3 or more</option>
						</select></td>
					</tr>
					<tr>
						<td>Does your home have a swimming pool?</td>
						<td><input type="radio" name="pool" value="true" required>
							Yes <input type="radio" name="pool" value="false"> No</td>
					</tr>

				</table>
				<br> <input type="submit" value="Continue"> <br> <br>
				<br>
			</form>
			<hr>
			<center>Copyright © 2018 HomeownerInsurance.com All Rights
				Reserved</center>
</html>