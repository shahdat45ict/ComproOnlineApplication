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
<c:url value="/resources/js/registration-login.js" var="jsURL" />
<script type="text/javascript" src="${jqueryURL}"></script>
<script type="text/javascript" src="${validatorURL}"></script>
<script type="text/javascript" src="${jsURL}"></script>
<title>Compro Online Application - Forgot Password</title>

</head>
<body>
<div id="wrapper">
<div id="wrapper_in">
<div id="header">
<span class="logo"><a href="/ComproOnlineApplication">Compro Online Application</a></span>
<img src="/ComproOnlineApplication/resources/images/header.png" width="1000" height="160" />
</div>
<div id="wrapper_middle">
<div id="wrapper_left">
Please enter your registered email below:
<form id="formForgotPassword" action="forgotPassword" method="post" class="cmxform">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
				
		</table>
		<input type="submit" value="submit" class="button" style="margin-left:158px;" />
		
				
				
	</form>
	<p>Do check your spam folder as well.</p>
	<p>If your email is the one you registered with,you should receive message on how to reset your password.</p>
	<p>If you do not receive email instruction on reseting your password,then you did not submit the correct email.</p>
	
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