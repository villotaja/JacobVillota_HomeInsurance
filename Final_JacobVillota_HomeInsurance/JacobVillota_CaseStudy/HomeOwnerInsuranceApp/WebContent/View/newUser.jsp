<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<HEAD>
<body style="background-color: lightyellow;">
	<TITLE>Homeowner Insurance</TITLE>
	<STYLE type="text/css">
H1 {
	text-align: center;
	color: #883f0a;
}

h2 {
	text-align: center;
	color: #883f0a;
}
</STYLE>
	<H1>Homeowner Insurance</H1>
	<hr>
	<center>
		<H2>
			<font size="4"> User Details </font>
		</H2>
		<br> Note: Password must be 8 characters with numbers and
		characters only<br>
		<br>
		<br> <font color="red"> ${InvalidRegister} </font>
		<form action="RegUser" method="post">
			<table>
				<tr>
					<td>User id<font color="red"> *</font></td>
					<td><input type="text" name="newUser" required></td>
				</tr>
				<tr>
					<td>Password <font color="red"> *</font></td>
					<td><input type="password" name="newpassword" required></td>
				</tr>
				<tr>
					<td>Re-enter password<font color="red"> *</font></td>
					<td><input type="password" name="repwd" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" name="reg"></td>
			</table>
		</form>
		<br> <br> <br> <br> <br>
		<hr>
		Copyright © 2018 HomeownerInsurance.com All Rights Reserved
	</center>
	<%session.removeAttribute("InvalidRegister"); %>

</html>