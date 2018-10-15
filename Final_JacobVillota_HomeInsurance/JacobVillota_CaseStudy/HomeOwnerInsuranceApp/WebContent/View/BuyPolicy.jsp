<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<title>Buy Policy</title>
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

req {
	
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
			<a href="Logout"> Logout</a><br> <hr>
			<H2>
				<font size="3">Buy Policy 
			</H2> <align="justify"> <b> Quote Id:<c:out value="${quote.getQuote_ID()}"/></b>
			<br>
			<p><form action= "buyQuote" method="get">
				<font color="red">Note:</font> <b>Policy start date cannot be
					more than 60 days from today's date</b><br> <br>Enter Policy
				Start Date: <input type="text" name="start_date">mm/dd/yyyy<br>
				<br>
				<a href="../View/TAC.jsp"> Please Click and read terms and
					conditions before buying policy</a><br>
				<br> <input type="checkbox" name="Termsandcondition"
					value="TAC" required> This is to acknowledge that I have read the
				terms and conditions of the policy.<br>
			</p>
			<input type="submit" value="Submit"> <br></form>
			<br>
			<br>
			<br>
			<hr>
			<center>Copyright © 2018 HomeownerInsurance.com All Rights
				Reserved</center>
</html>



