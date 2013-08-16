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
						    <fieldset>
					 		 <legend>Personal Information</legend>
							<table>
								<tr>
									<td><b>Name : </b></td>
									<td>${application.personalInfo.firstName}
										${application.personalInfo.middleName}
										${application.personalInfo.surName}</td>
								</tr>
								<tr>
									<td><b>Date Of Birth : </b></td>
									<td>${application.personalInfo.dateOfBirth}</td>
								</tr>
								<tr>
									<td><b>City Live In : </b></td>
									<td>${application.personalInfo.cityLiveIn}</td>
								</tr>
								<tr>
									<td><b>Country Live In : </b></td>
									<td>${application.personalInfo.countryLiveIn}</td>
								</tr>
								<tr>
									<td><b>Country Of Citizenship : </b></td>
									<td>${application.personalInfo.countryOfCitizenship}</td>
								</tr>
								<tr>
									<td><b>Country Of Birth</b></td>
									<td>${application.personalInfo.countryOfBirth}</td>
								</tr>
								<tr>
									<td><b>Sex : </b></td>
									<td>${application.personalInfo.sex}</td>
								</tr>
								<tr>
									<td><b>Marital Status : </b></td>
									<td>${application.personalInfo.maritalStatus}</td>
								</tr>
								<tr>
									<td><b>Email : </b></td>
									<td>${application.personalInfo.email}</td>
								</tr>
								<tr>
									<td><b>Phone : </b></td>
									<td>${application.personalInfo.phone}</td>
								</tr>
								<tr>
									<td><b>Skype Id : </b></td>
									<td>${application.personalInfo.skypeId}</td>
								</tr>
								<tr>
									<td><b></b></td>
									<td></td>
								</tr>
							</table>
							</fieldset>
							<fieldset>
							<legend>English Proficiency</legend>
							
							<table>
								<tr>
									<td><b>How Well Read Write English : </b></td>
									<td>${application.englishProficiency.howWellReadWriteEnglish}</td>
								</tr>
								<tr>
									<td><b>How Well Speak English : </b></td>
									<td>${application.englishProficiency.howWellSpeakEnglish}</td>
								</tr>
								<tr>
									<td><b>How Well Understand Spoken English : </b></td>
									<td>${application.englishProficiency.howWellUnderstandSpokenEnglish}</td>
								</tr>
								<tr>
									<td><b>Toefl Year Taken : </b></td>
									<td>${application.englishProficiency.toeflYearTaken}</td>
								</tr>
								<tr>
									<td><b>Toefl Score : </b></td>
									<td>${application.englishProficiency.toeflScore}</td>
								</tr>
								<tr>
									<td><b>GRE Year Taken</b></td>
									<td>${application.englishProficiency.greYearTaken}</td>
								</tr>
								<tr>
									<td><b>GRE Verbal Score : </b></td>
									<td>${application.englishProficiency.toeflScore}</td>
								</tr>
								<tr>
									<td><b>GRE Verbal Percentile : </b></td>
									<td>${application.englishProficiency.greVerbalPercentile}</td>
								</tr>
								<tr>
									<td><b>GRE Quantitative Score : </b></td>
									<td>${application.englishProficiency.greQuantitativeScore}</td>
								</tr>
								<tr>
									<td><b>GRE Quantitative Percentile : </b></td>
									<td>${application.englishProficiency.greQuantitativePercentile}</td>
								</tr>
								<tr>
									<td><b>GRE Analytical Score : </b></td>
									<td>${application.englishProficiency.greAnalyticalScore}</td>
								</tr>
								<tr>
									<td><b>GRE Analytical Percentile : </b></td>
									<td>${application.englishProficiency.greAnalyticalPercentile}</td>
								</tr>
							</table>
							</fieldset>
							<c:if test="${application.status  == 'submitted'}">
								<form method="post"
									action="../application/setapplicationdisposition/${application.id}"
									id="formDisposition" class="cmxform">
						            <fieldset>
										<legend>Set Application Disposition</legend>
									<select id="selectDisposition" name="disposition">
										<option value="pass"
											<c:if test="${application.disposition == 'pass'}">selected="selected"</c:if>>Pass</option>
										<option value="fail"
											<c:if test="${application.disposition == 'fail'}">selected="selected"</c:if>>Fail</option>
										<option value="undetermined"
											<c:if test="${application.disposition == 'undetermined'}">selected="selected"</c:if>>Un
											Determined</option>
									</select> <input type="submit" value="Set Disposition" class="button"
										style="width: auto; margin-left: 158px; padding:0 5px 4px 5px; text-align: center; color: #444444;" />
										</fieldset>
								</form>
							</c:if>
							<c:if test="${application.status  == 'submitted'}">
								<form method="post"
									action="../application/set-application-unsubmitted/${application.id}"
									id="formDisposition" class="cmxform">
									<fieldset>
										<legend>Set Application Un Submitted</legend>
										<select id="selectStatus" name="status">
											<option value="submitted"
												<c:if test="${application.status == 'submitted'}">selected="selected"</c:if>>Submitted</option>
											<option value="un-submitted"
												<c:if test="${application.status == 'un-submitted'}">selected="selected"</c:if>>Un
												Submitted</option>
										</select> <input type="submit" value="Set Application Un Submitted"
											class="button" style="width: auto; margin-left: 158px; padding: 0 5px 4px 5px; text-align: center; color: #444444;" />
									</fieldset>
								</form>
							</c:if>

						</c:otherwise>
					</c:choose>


				</div>
				<div id="wrapper_right">
					<c:if test="${not empty user}">Welcome ${user.firstName} ${user.lastName}</c:if>
					<br style="clear: both" /> <br style="clear: both" />
					<h3 class="widget-title">Meta</h3>
					<ul>
						<li><a href="/ComproOnlineApplication/dashboard">Dashboard</a></li>
						<li><a href="/ComproOnlineApplication/logout">Log Out</a></li>
					</ul>
				</div>

				<div id="footer">
					<div id="colophon">
						<div id="site-info">
							<a rel="home" title="Compro Online Application"
								href="/ComproOnlineApplication">Compro Online Application</a>
							<span class="cpyrt">Maharishi University Of Management &copy; 2013</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>