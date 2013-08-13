<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/css/style.css" var="cssURL" />
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Compro Online Application - Application Detail</title>
</head>
<body>
	<div id="wrapper">
		<div id="wrapper_in">
			<div id="header">
				<span class="logo"><a href="/ComproOnlineApplication">Compro
						Online Application</a></span> <img
					src="/ComproOnlineApplication/resources/images/header.png"
					width="1000" height="160" />
			</div>
			<div id="wrapper_middle">
			<div id="wrapper_left">
			   <h1 class="admin-title">Application Detail</h1>
			        
					<c:choose>
						<c:when test="${empty application}">
                                  There is no submitted application to show
                        </c:when>
						<c:otherwise>
						<h1 class="title">Personal Information</h1>
                        <table>
						  <tr><td><b>Name : </b></td><td>${application.personalInfo.firstName} ${application.personalInfo.middleName} ${application.personalInfo.surName}</td></tr>
						  <tr><td><b>Date Of Birth : </b></td><td>${application.personalInfo.dateOfBirth}</td></tr>
						  <tr><td><b>City Live In : </b></td><td>${application.personalInfo.cityLiveIn}</td></tr>
						  <tr><td><b>Country Live In : </b></td><td>${application.personalInfo.countryLiveIn}</td></tr>
						  <tr><td><b>Country Of Citizenship : </b></td><td>${application.personalInfo.countryOfCitizenship}</td></tr>
						  <tr><td><b>Country Of Birth</b></td><td>${application.personalInfo.countryOfBirth}</td></tr>
						  <tr><td><b>Sex : </b></td><td>${application.personalInfo.sex}</td></tr>
						  <tr><td><b>Marital Status : </b></td><td>${application.personalInfo.maritalStatus}</td></tr>
						  <tr><td><b>Email : </b></td><td>${application.personalInfo.email}</td></tr>
						  <tr><td><b>Phone : </b></td><td>${application.personalInfo.phone}</td></tr>
						  <tr><td><b>Skype Id : </b></td><td>${application.personalInfo.skypeId}</td></tr>
						  <tr><td><b></b></td><td></td></tr>
						</table>
<h1 class="title">English Proficiency</h1>
					
					<h1 class="title">Education History</h1>
					
					<h1 class="title">Set Application Disposition</h1>
	<form method="post" action="../application/setapplicationdisposition/${application.id}" id="formDisposition" class="cmxform">
				 <select id="selectDisposition" name="disposition">
				   <option value="pass" <c:if test="${application.disposition == 'pass'}">selected="selected"</c:if>>Pass</option>
				   <option value="fail" <c:if test="${application.disposition == 'fail'}">selected="selected"</c:if>>Fail</option>
				   <option value="undetermined" <c:if test="${application.disposition == 'undetermined'}">selected="selected"</c:if>>Un Determined</option>
				 </select>
         <input type="submit" value="Set Disposition" class="button" style="width: auto; margin-left: 158px;" />
	</form>
	
	<c:if test="${application.status  == 'submitted'}">	

	<h1 class="title">Set Application Un Submitted</h1>
	<form method="post" action="../application/set-application-unsubmitted/${application.id}" id="formDisposition" class="cmxform">
				 <select id="selectStatus" name="status">
				   <option value="submitted" <c:if test="${application.status == 'submitted'}">selected="selected"</c:if>>Submitted</option>
				   <option value="un-submitted" <c:if test="${application.status == 'un-submitted'}">selected="selected"</c:if>>Un Submitted</option>
				 </select>
         <input type="submit" value="Set Application Un Submitted" class="button" style="width: auto; margin-left: 158px;" />
	</form>	

	</c:if>
						
						</c:otherwise>
					</c:choose>
					
					
			  </div>
			  <div id="wrapper_right">
			   		<h3 class="widget-title">Meta</h3>
					<ul>
					    <li><a href="../dashboard">Dashboard</a></li>
						<li><a href="../logout">Log Out</a></li>					
					</ul>
			  </div>
			
		    <div id="footer">
				<div id="colophon">
					<div id="site-info">
						<a rel="home" title="Compro Online Application"
							href="/ComproOnlineApplication">Compro Online Application</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>