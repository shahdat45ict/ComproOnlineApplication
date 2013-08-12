<%@page import="java.text.Normalizer.Form"%>
<%@page import="org.springframework.ui.Model"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
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
<c:url value="/resources/js/educationhistoryvalidator.js" var="validator" />
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
<span class="logo"><a href="/ComproOnlineApplication">Compro Online Application</a></span>
<img src="/ComproOnlineApplication/resources/images/header.png" width="1000" height="160" />
</div>
		<div id="wrapper_middle">
			<div id="wrapper_left">
					<form:form action="submiteducationhistoryform" method="post" id="educationhistoryform" class="cmxform" name="educationhistoryform" commandName="form">  
					<form:hidden path="educationHistoryId"/>
					<div class="header">Educational History:</div>
					<div class="box">
						<span class="subHeader">High School/Secondary Level
							Education</span>
						<table class="indent">

							<tr>
								<td colspan="2">
									${form.whetherHighLevelEducation == "Yes" ? "YES, I graduated from high school." : "NO, I did not graduate from high school."}
								</td>
							</tr>
						</table>
						<br />
						<span class="subHeader">Highest Degree Applicable</span>
						<table class="indent">
							<tr>
								<td colspan="3" class="description">Please select the
									degree most applicable to this application <br />
								<br />
								</td>
							</tr>
							<tr>
								<th>Years</th>
								<th>Field</th>
								<th>Degree</th>
							</tr>
							<tr>
								<td>
									${form.highestDegreeYear}
								</td>
								<td>
									${form.highestDegreeField}
								</td>
								<td>
									${form.highestDegree}
								</td>
							</tr>
						</table>
						<br />
						
						<span class="subHeader">Grade Point Average for Degree Indicated Above</span>
						<br />
						<table class="indent">
							<tr>
								<td>Country Degree was Granted:</td>
								<td>
									${form.highestDegreeCountry}
								</td>
							</tr>
							<tr>
								<td>Grading Scale Used:</td>
								<td>
									${form.gradingScaleUser}
								</td>
							</tr>
							<tr>
								<td>
									GPA for selected Degree:
								</td>
								<td>
									${form.highestDegreeGPA}
								</td>  
							</tr>

						</table>
						<br /> 
						<span class="subHeader">Total Years / Months of Post
							Secondary Education</span>
						<table class="indent">
							<tr>
								<td class="description">Indicate the total number of years
									and months of post-senior-secondary full-time education (after
									your 12th grade/class). Include education at accredited
									institutions only -- universities, colleges, institutes.
									Include undergraduate and graduate level work.</td>
							</tr>
							<tr>
								<td>Years: 
								${form.totalYearOfSecondaryEdu}
									&nbsp;&nbsp; Months: 
								${form.totalMonthOfSecondaryEdu}
								<br />
								</td>
							</tr>
						</table>
						<br />
					</div>
					<br />
					<br />
					<input type="button" value="Back" class="button"
						style="margin-left: 100px;" onclick="back()"/>
						
				</form:form>
					
<script type="text/javascript">
function back(){
	window.history.go(-1);
}
function saveForm(){
	var url="saveeducationhistoryform";
    document.educationhistoryform.action = url;
	document.educationhistoryform.submit();
	}
/* $(function(){
	$("#btnSubmit").click(function(){		
		 alert("hh");
		var url="../submiteducationhistoryform";
	    document.educationhistoryform.action = url;
		document.educationhistoryform.submit(); 
	});
}); */

</script>
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
