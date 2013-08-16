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
<img src="/ComproOnlineApplication/resources/images/header.png" width="1000" height="160" />
</div>
<div id="wrapper_middle">

<div id="wrapper_left">
<object type="application/x-shockwave-flash" style="width:700px;height:370px;" data="http://www.youtube.com/v/wcUMMIrDy48&amp;hl=en&amp;fs=1" title="JoomlaWorks AllVideos Player">
 <param name="movie" value="http://www.youtube.com/v/wcUMMIrDy48&amp;hl=en&amp;fs=1">
 <param name="quality" value="high">
 <param name="wmode" value="transparent">
 <param name="bgcolor" value="#010101">
 <param name="allowfullscreen" value="true">
 <param name="allowscriptaccess" value="always">
</object>
</div>
<div id="wrapper_right">
<c:if test="${not empty user}">Welcome ${user.firstName} ${user.lastName}</c:if>
<br style="clear: both" /><br style="clear: both" />
<h3 class="widget-title">Meta</h3>
                      <ul>
					    <c:choose>
						<c:when test="${empty user}">
  							<li><a href="registration">Register</a></li>
  							<li><a href="login">Log in</a></li>
                        </c:when>
						<c:otherwise>
						      <c:if test="${not empty userType and userType  == 'Administrator'}"> <li><a href="dashboard">Dashboard</a></li> </c:if>
                              <c:if test="${not empty userType and userType  == 'AdmissionStaff'}"> <li><a href="dashboard">Dashboard</a></li> </c:if>
                              <c:if test="${not empty userType and userType  == 'Applicant'}"> <li><a href="application">Application</a></li> </c:if>
  							  <li><a href="changePassword">Change Password</a></li>
                              <li><a href="logout">Log out</a></li>						
						</c:otherwise>
						</c:choose>
					 </ul>	
</div>
</div>
<div id="footer">
  <div id="colophon">
	  <div id="site-info">
	    <a rel="home" title="Compro Online Application" href="/ComproOnlineApplication">Compro Online Application</a>
	    <span class="cpyrt">Maharishi University Of Management &copy; 2013</span>
	  </div>
  </div>
</div>
</div>	
</div>
</body>
</html>