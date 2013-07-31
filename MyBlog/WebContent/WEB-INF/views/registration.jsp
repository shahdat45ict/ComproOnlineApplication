<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/css/style.css" var="cssURL" />
<c:url value="/resources/css/style.css" var="validatorCssURL" />  
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<link rel="stylesheet" type="text/css" media="screen" href="${validatorCssURL}" />  
<c:url value="/resources/js/jquery-2.0.3.min.js" var="jqueryURL" />
<c:url value="/resources/js/jquery.validate.min.js" var="validatorURL" />
<c:url value="/resources/js/comproOnline.js" var="jsURL" />
<script type="text/javascript" src="${jqueryURL}"></script>
<script type="text/javascript" src="${validatorURL}"></script>
<script type="text/javascript" src="${jsURL}"></script>
<title>Compro Online Application - Registration</title>

</head>
<div id="wrapper">
<div id="wrapper_in">
<div id="header">
<span class="logo"><a href="/ComproOnlineApplication">Compro Online Application</a></span>
<img src="/ComproOnlineApplication/resources/images/berries.jpg" width="1000" height="198" />
</div>
<div id="wrapper_middle">
<div id="wrapper_left">
<form action="registration" method="post" id="formRegistration" class="cmxform">
		<table>
			<tr>
				<td><label for="txtFirstName">First Name:</label></td>
				<td><input id="txtFirstName" name="firstName" type="text"/></td>
			</tr>
			<tr>
				<td><label for="txtLastName">Last Name:</label></td>
				<td><input id="txtLastName" type="text" name="lastName"/></td>
			</tr>
			<tr>
				<td><label for="txtEmail">Email:</label></td>
				<td><input id="txtEmail" type="text" name="email"/>
				</td>
			</tr>
			<tr>
				<td><label for="txtPassword">Password:</label></td>
				<td><input id="txtPassword" type="password" name="password"/></td>
			</tr>
			<tr>
				<td><label for="txtConfirmPassword">Confirm Password:</label></td>
				<td><input id="txtConfirmPassword" type="password" name="confirmPassword"/></td>
			</tr>
		</table>
		<%@page import="java.util.Calendar"%>
		<%@page import="java.util.GregorianCalendar"%>
		 <%
		      GregorianCalendar cal = new GregorianCalendar();
		 %>
		<input type="hidden" name="registered" value="<% out.print(cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE)); %>" />
		<input type="submit" value="Submit" class="button" style="margin-left:158px;" />		
	</form>

</div>
<div id="wrapper_right">

</div>	
</div>
<div id="footer">
  <div id="colophon">
	  <div id="site-info">
	    <a rel="home" title="Compro Online Application" href="/ComproOnlineApplication">Compro Online Application</a>
	  </div>
  </div>
</div>
</div>	
</div>
</body>
</html>	