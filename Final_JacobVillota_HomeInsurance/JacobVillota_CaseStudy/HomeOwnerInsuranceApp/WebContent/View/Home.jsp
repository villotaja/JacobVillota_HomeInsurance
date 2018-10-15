<!doctype HTML5>
<html>
<title>Home</title>
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
		<imgsrc
			="C:\Users\Student\Desktop\QE02\casestudyexternalfiles\homepicture.jpg"
						alt="house should be here"
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
				<font size="3">Get Started Page 
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
							<img
								src="C:\Users\Student\Desktop\QE02\casestudyexternalfiles\casestudytwostory.png"
								alt="house should be here" height="150" width="200">
					</div>
					<div>
						<br>
						<br>
						<br>
						<table align="left">
							<tr>
								<td>
									<form action="../View/GetQuote.jsp" method="get">
										<input type="submit" value="Get a Quote" name="quote">
									</form>
									<br>
								<br>
								</td>
							</tr>
							<tr>
								<td>
									<form action="QuoteDetails" method="get" name="QuoteDets">
										<input type="submit" value="Retrieve Quote">
									</form>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<hr>
				<center>Copyright © 2018 HomeownerInsurance.com All Rights
					Reserved</center>
</html>