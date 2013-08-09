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
<div id="wrapper_right">
<h3 class="widget-title">Meta</h3>
<ul>
	<li><a href="registration">Register</a></li>
	
	<li><a href="login">Log in</a></li>
</ul>
</div>	
<%-- 	
	<c:forEach var="post" items="${posts}">	
		<div class="post">
			<a href="details/${post.id}" class="title">${post.title}</a>
			<p class="content">
			   ${post.content}
			</p>
			<a href="details/${post.id}">read more</a>
		</div>
	</c:forEach> 
--%>
<p><b>COMPUTER PROFESSIONAL PROGRAM</b></p>
<p><b>MASTER OF SCIENCE IN COMPUTER SCIENCE</b></p>	
<p><b>MAHARISHI UNIVERSITY OF MANAGEMENT, USA</b></p><br /><br />	
<p>1. Before applying, please review the Admission Requirements.</p>
<p>2. Complete the ONLINE APPLICATION FORM.</p>
<p>NOTE: After clicking, please wait until the application downloads comletely before filling it out. This may take a few minutes depending on the speed of your Internet connection.</p>

<p>Entry dates are in February, June, and October. We have no formal application deadlines.</p>

<p>It's easy to apply online</p>
<p>Provide all information requested on the online form. Note: False or misleading information in any part of an application may result in immediate dismissal from the Program.
When the form is completed, click the "Send Data" button at the bottom of the form. You will hear back from us within 5 to 10 days.
Soon after you have submitted your application, we will notify you of your preliminary status. Applicants who meet the basic admission requirements will then be asked to: (1) take an online technical proficiency test, (2) send in their transcripts and other documents, (3) have their spoken English assessed by phone, and (4) pay the application fee of US $50.</p>

<p>Final acceptance will normally take from 2 to 3 weeks from the time all application materials are received by the Admissions Office.</p>

<p>Attention: To expedite your application, we strongly recommend that you now obtain your college transcripts and diplomas (and GRE and TOEFL scores if you have taken these tests) so you will be prepared to immediately submit these items when the University requests them. Please do not submit these documents or your resume (curriculum vitae) until the University requests them. See sample resume.</p>
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