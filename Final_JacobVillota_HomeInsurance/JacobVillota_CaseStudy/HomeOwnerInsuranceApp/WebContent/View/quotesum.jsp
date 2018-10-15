<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype HTML5>
<html>
<title>Quote Summary</title>
<HEAD>
<body style="background-color: lightyellow;">
	<TITLE></TITLE>
	<STYLE type="text/css">
H1 {
	text-align: center;
	color: #883f0a;
}
H2 {
	text-align: center;
	color: #883f0a;
}
 #collectionsTop {
    width: 100%;
    height: 100%;
    overflow:hidden;
   }
    .topRight {
    width:50%;
    height:100%;
    float:left;
    overflow:hidden;
    }
    .topLeft {
    width:50%;
    height:100%;
    float:left;
    overflow:hidden;
    }
    #collectionsBottom {
    width: 100%;
    height: 100%;
    overflow:hidden;
    }
    .bottomRight { 
    width:50%;
    height:100%;
    float:left;
    overflow:hidden;
      
    }
    .bottomLeft {
    width:50%;
    height:100%;
    float:left;
    overflow:hidden;
    }
</STYLE>
	<H1>
		<img
			src="C:\Users\Student\Desktop\QE02\casestudyexternalfiles\homepicture.jpg"
			height="50" width="50"> <font size=""> Homeowner
			Insurance 
	</H1>
	<center>
		<font size="4"> <a href="Home.jsp"> Home</a> | <a
			href="GetQuote.jsp"> Get Quote</a> | <a href="QuoteDetails">
				Retrieve Quote</a> | <a href="AllPolicies"> My Policies</a>|
			<a href="Logout"> Logout</a><br>
			<hr>
			<H2>
				<font size="3">Quote Summary
          </H2></center>
        
      <Left> <b> Monthly Premium </b> <font color="red"> $</font><c:out value="${quote.getMonthly_Premium()}"/> </Left>
			<form action="../View/BuyPolicy.jsp" method="get"><input type="submit" value="Buy Quote"> </form>
      
<div id="collectionsTop">
        <div class="topRight"><br><table>
        <th> <b> Location Details</b> </th>
        <tr><td><em> Quote Id</td><td><c:out value="${quote.getQuote_ID()}"/></td></tr>
        <tr><td><em> Residence Type</td><td><c:out value="${location.getResidence_type()}"/></td></tr>
        <tr><td><em> Address Line 1</td><td><c:out value="${location.getAddress_line_1()}"/></td></tr>
        <tr><td><em> Address Line 2</td><td><c:out value="${location.getAddress_line_2()}"/></td></tr>
        <tr><td><em> City</td><td><c:out value="${location.getCity()}"/></td></tr>
        <tr><td><em> State</td><td><c:out value="${location.getLocation_state()}"/></td></tr>
        <tr><td><em> Zip</td><td><c:out value="${location.getZipcode()}"/></td></tr>
        <tr><td><em> Residence Use</td><td><c:out value="${location.getResidence_use()}"/></td></tr>
        </table><hr></div>
  
        <div class="topLeft"><br><table>
        <th> <b> Homeowner Details</b> </th>
        <tr><td><em> First Name</td><td><c:out value="${HO.getFirstName()}"/></td></tr>
        <tr><td><em> Last Name</td><td><c:out value="${HO.getLastName()}"/></td></tr>
        <tr><td><em> Date of Birth</td><td><c:out value="${HO.getBirthday()}"/></td></tr>
        <tr><td><em> Is Retired</td><td><c:out value="${HO.isRetired()}"/></td></tr>
        <tr><td><em> Social Secruity Number</td><td><c:out value="${HO.getSsn()}"/></td></tr>
        <tr><td><em> Email Address</td><td><c:out value="${HO.getEmail()}"/></td></tr>
        <tr><td><em> &nbsp  </td><td></td></tr>  
        <tr><td><em> &nbsp  </td><td></td></tr>
        <tr><td><em> &nbsp  </td><td></td></tr>  
        </table> <hr></div>
    </div>
    <div id="collectionsBottom">
        <div class="bottomRight"><br><table>
        <th> <b> Market Value</b> </th>
        <tr><td><em> Year Built</td><td><c:out value="${Prop.getYear_Build()}"/></td></tr>
        <tr><td><em> Square Footage</td><td><c:out value="${Prop.getSQ_Feet()}"/></td></tr>
        <tr><td><em> Dwelling Style</td><td><c:out value="${Prop.getDwelling_Style()}"/></td></tr>
        <tr><td><em> Roof Material</td><td><c:out value="${Prop.getRoof_Material()}"/></td></tr>
        <tr><td><em> Garage Type</td><td><c:out value="${Prop.getGarage_Type()}"/></td></tr>
        <tr><td><em> Number of Full Baths</td><td><c:out value="${Prop.getNum_Baths()}"/></td></tr>
        <tr><td><em> Number of Half Baths</td><td><c:out value="${Prop.getHalf_Baths()}"/></td></tr>
        <tr><td><em> Has Swimming Pool?</td><td><c:out value="${Prop.isSwimming_Pool()}"/></td></tr>
        </table></div>
        <div class="bottomLeft"><br><table>
        <th> <b> Coverage Details</b> </th>
        <tr><td><em> Monthly Premium</td><td>$<c:out value="${quote.getMonthly_Premium()}"/></td></tr>
        <tr><td><em> Dwelling Coverage</td><td>$<c:out value="${quote.getDwelling_Coverage()}"/></td></tr>
        <tr><td><em> Detached Structure</td><td>$<c:out value="${quote.getDetached_Structures()}"/></td></tr>
        <tr><td><em> Personal Property</td><td>$<c:out value="${quote.getPersonal_Property()}"/></td></tr>
        <tr><td><em> Additional Living expense</td><td><c:out value="${quote.getAdditional_Living_EXP()}"/></td></tr>
        <tr><td><em> Medical Expense</td><td>$<c:out value="${quote.getMed_Exp()}"/></td></tr>
        <tr><td><em> Deductible</td><td>$<c:out value="${quote.getDeductible()}"/></td></tr>
        </table></div>
     </div>
        
        
        <br><form action="../View/QuoteDetails.jsp" method="get"> <input type="submit" value="Go Back"></form>
									 <form action="../View/BuyPolicy.jsp" method="get"><input type="submit" value="Buy Quote"> </form>
        <br><br>
          <hr>
  <center>  Copyright © 2018 HomeownerInsurance.com All Rights Reserved</center>
          </html>
