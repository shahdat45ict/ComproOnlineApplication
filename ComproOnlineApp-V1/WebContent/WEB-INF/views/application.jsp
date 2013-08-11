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
	<span class="logo"><a href="/ComproOnlineApplication"></a></span>
	<img src="/ComproOnlineApplication/resources/images/header.png" width="1000" height="198" />
</div>
<div id="wrapper_middle">

<div id="wrapper_left">
<div id="accordion">
<h3>Instruction</h3>
  <div style="height: 100px !important;">
    <p>
    Cras dictum. Pellentesque habitant morbi tristique senectus et netus
    et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in
    faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
    mauris vel est.
    </p>
    <p>
    Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
    Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
    inceptos himenaeos.
    </p>
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
  
</div>
</div>
<div id="wrapper_right">
 <ul>
 <li><a href="../logout">Log Out</a></li>
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