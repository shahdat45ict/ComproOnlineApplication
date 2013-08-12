<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application</title>
<c:url value="/resources/css/style.css" var="cssURL" />  
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />  
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
 <script>
$(function() {
$( "#accordion" ).accordion({
heightStyle: "content"
});
});
</script>
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
<div id="accordion">
<h3>Instruction</h3>
  <div>
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
  <h3>Personal Information</h3>
  <div>
 	  <jsp:include page="/WEB-INF/views/personalinfo.jsp" flush="true"></jsp:include>
  </div>
  <h3>English Proficiency</h3>
  <div>
 	  <jsp:include page="/WEB-INF/views/englishproficiency.jsp" flush="true"></jsp:include>
  </div>
  <h3>Education History</h3>
  <div>
 	  <jsp:include page="/WEB-INF/views/educationhistoryform.jsp" flush="true"></jsp:include>
  </div>
  <h3>Application Form Information Agreement</h3>
  <div>      
 	  <form method="post" action="application/submitapplication" id="formApplication" class="cmxform">
		<input type="checkbox" name="agreement" value="yes">I hereby certify that all of the information provided in this form is true and accurate, and I further certify that I have carefully read the entire agreement and agree to all provisions
         <input type="submit" value="Submit Application" class="button" style="width: auto; margin-left: 158px;" />
	</form>
	<p>
		<b>IMPORTANT NOTE:</b> You will receive a confirmation email when your
		application is received. If you do not receive this confirmation email
		within 5 days, then please email directly to our Admissions office at
		admissionstaff1@mum.com. We find that sometimes our response emails
		are caught in spam folders, or there may have been a network failure.
	</p>
	<p>Please click the "Submit" button only once. If you do not see a
		JavaScript alert, then your data is being sent. Please wait online
		until a confirmation screen appears.</p>
  </div>
</div>
</div>
<div id="wrapper_right">
 <ul>
 <li><a href="logout">Log Out</a></li>
 </ul>
</div>
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