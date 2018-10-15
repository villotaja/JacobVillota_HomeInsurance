<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homeowner Login</title>
<style type="text/css">
H1 {
	text-align: center;
	color: #883f0a;
}

* {
	box-sizing: border-box;
}

.column {
	float: left;
	width: 45%;
	padding: 20px;
	height: 400px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>

<body style="background-color: lightyellow;">
	<h1>Homeowner Insurance</h1>
	<hr>
	<div class="row">
		<div class="column">

			<i>
					Home insurance, also commonly called hazard insurance or
					homeowner'sinsurance, is a type of property insurance that covers a
					private residence, such as condominium or renters' insurance or
					home or multiple unit buildings. 
					<br><br> 
					It is an insurance policy that combines various personal
					insurance protections, which can include losses occuring to one's
					home, its contents, loss of use (additional living expenses), or
					loss of other personal possessions of the homeowner, as well as
					liability insurance for accidents that may happen at the home or at
					the hands of the homeowner within the place territory. If a home
					does not meet the underwriting guidelines of a standard homeowners
					policy the residence could qualify for a limited coverage dwelling
					policy
					</i>
				</p>
			
			
		</div>
			<div class="column">
				<center>
					<img
					src="C:\Users\Student\Desktop\QE02\casestudyexternalfiles\homepicture.jpg"
					height="150" width="200">
				</center>
				<br><br>
				<form action="LoginPage" method="post">
					<table style="width: 25%">
						<tr>
							<th></th>
							<th></th>
						</tr>
						<tr>
							${InvalidPassword}
							<td>User id</td>
							<td><input type="text" name="uname" size="20" require></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="pwd" size="20" require></td>
						</tr>
						<td>
							<input type="Submit" value="Login">
						</td>
					</table>
				</form>
				NewUser?
				<a href="/HomeOwnerInsuranceApp/View/newUser.jsp"> Register here</a>
			</div>
		</div>
	</body>
	<hr>
	<center>
		Copyright © 2018 HomeownerInsurance.com All Rights Reserved
	</center>
</html>