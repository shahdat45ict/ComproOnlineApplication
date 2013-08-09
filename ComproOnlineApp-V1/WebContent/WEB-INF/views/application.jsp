<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/css/style.css" var="cssURL" />  
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />  
<title>Compro Online Application</title>
</head>
<body>
<div id="wrapper">
<div id="wrapper_in">
<div id="header">
<span class="logo"><a href="/ComproOnlineApplication">Compro Online Application</a></span>
<img src="/ComproOnlineApplication/resources/images/berries.jpg" width="1000" height="198" />
</div>
<div id="wrapper_middle">
<div id="wrapper_left">
 <h2>${user.firstName},welcome you!</h2> 
</div>
<div id="wrapper_right">
<h3 class="widget-title">Meta</h3>
<ul>
	<li><a href="logout">log out</a></li>
	<li><a href="changePassword">Change password</a></li>
	<li><a href="application/educationhistoryform">Education History Form</a></li>
	<li><a href="application/personalinfo">Personal Information</a>
	<li><a href="englishproficiency">English Proficiency</a></li>
	<li><a href="englishproficiency/1">Update English Proficiency</a>
</ul>
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