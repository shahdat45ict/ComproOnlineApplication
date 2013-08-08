<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/css/style.css" var="cssURL" />
<c:url value="/resources/css/style.css" var="validatorCssURL" />
<c:url value="/resources/css/educationhistory.css"
	var="educationhistory" />
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${validatorCssURL}" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${educationhistory}" />
<c:url value="/resources/js/jquery-2.0.3.min.js" var="jqueryURL" />
<c:url value="/resources/js/jquery.validate.min.js" var="validatorURL" />
<c:url value="/resources/js/comproOnline.js" var="jsURL" />
<c:url value="/resources/js/appCheck.js" var="appCheck" />
<c:url value="/resources/js/appLogic.js" var="appLogic" />
<c:url value="/resources/js/validator.js" var="validator" />
<script type="text/javascript" src="${jqueryURL}"></script>
<script type="text/javascript" src="${validatorURL}"></script>
<script type="text/javascript" src="${jsURL}"></script>
<script type="text/javascript" src="${appCheck}"></script>
<script type="text/javascript" src="${appLogic}"></script>
<script type="text/javascript" src="${validator}"></script>
<title>Compro Online Application - Education History Form</title>
</head>

<body>
<div id="wrapper">
	<div id="wrapper_in">
		<div id="header">
			<span class="logo"><a href="/ComproOnlineApplication">Education History Form</a></span>
			<img src="/ComproOnlineApplication/resources/images/berries.jpg"
				width="1000" height="198" />
		</div>
		<div id="wrapper_middle">
			<div id="wrapper_left">
				<form action="../saveeducationhistoryform" method="post"
					id="educationhistoryform" class="cmxform" name="educationhistoryform">
					<span class="subHeader">Colleges, Universities and
							other Post-Secondary Institutes Attended</span>
						<table class="indent">

							<tr>
								<td class="description" colspan="2">Please provide us with
									the details of each Post-Secondary institute you have attended
									by filling out the following fields:<br />
								<br />
							</tr>
							<tr>
								<td>Institute Name</td>
								<td align="right"><input type="text" name="instituteName"
									value="" id="instituteName" size="100" maxlength="125"
									style="width: 450px" /></td>
							</tr>
							<tr>
								<td>Location</td>
								<td align="right"><input type="text"
									name="location" value="" id="location"
									size="100" maxlength="125" style="width: 450px" /></td>
							</tr>
							<tr>
								<td>Dates-from/to</td>
								<td align="right"><input type="text"
									name="dataFrom" value="" id="dataFrom" size="100"
									maxlength="90" style="width: 450px" /></td>
							<tr>
								<td>Degree Granted</td>
								<td align="right"><input type="text"
									name="degreeGranted" value="" id="degreeGranted" size="100"
									maxlength="90" style="width: 450px" /></td>
							</tr>
							<tr>
								<td>Subject Area</td>
								<td align="right"><input type="text"
									name="subjectArea" value="" id="subjectArea" size="100"
									maxlength="90" style="width: 450px" /></td>
							</tr>
							<tr>
								<td>GPA</td>
								<td align="right"><input type="text" name="gpa"
									value="" id="gpa" size="100" maxlength="20"
									style="width: 450px" /></td>
							</tr>
							<tr>
								<td colspan="2" align="right">Please add <i><b>all</b></i>
									institutes attended:&nbsp;&nbsp;
									<button type="button"
										onClick="return addFromInput('Institute');">Add
										another institute</button>
								</td>
							</tr>

							<tr>
								<td colspan="2">
									<div class="innerBox" id="Institute"></div>
							</tr>
						</table>
						<input type="submit" value="Submit" class="button" style="margin-left: 158px;" onclick="return submit();"/>
						<input type="submit" value="save" class="button" style="margin-left: 158px;"/>
				</form>

			</div>
			<div id="wrapper_right"></div>
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
</body>
</html>
