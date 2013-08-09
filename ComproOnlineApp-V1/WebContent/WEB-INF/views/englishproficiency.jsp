<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/css/style.css" var="cssURL" />
<c:url value="/resources/css/style.css" var="validatorCssURL" />
<c:url value="/resources/css/blueWorld.css" var="mumCssURL" />
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${validatorCssURL}" />
<c:url value="/resources/js/jquery-2.0.3.min.js" var="jqueryURL" />
<c:url value="/resources/js/jquery.validate.min.js" var="validatorURL" />
<c:url value="/resources/js/comproOnline.js" var="jsURL" />
<script type="text/javascript" src="${jqueryURL}"></script>
<script type="text/javascript" src="${validatorURL}"></script>
<script type="text/javascript" src="${jsURL}"></script>
<link rel="stylesheet" type="text/css" href="${mumCssURL}" />
<title>Compro Online Application - English Proficiency</title>

</head>
<body>
	<div id="wrapper">
		<div id="wrapper_in">
			<div id="header">
				<span class="logo"><a href="/ComproOnlineApplication">Compro Online Application</a></span>
				<img src="/ComproOnlineApplication/resources/images/berries.jpg"	width="1000" height="198" />
			</div>
			<div id="wrapper_middle">
				<div id="wrapper_left">								  	
					<form action="/ComproOnlineApplication/englishproficiency<c:if test='${not empty englishProficiency.id}'>/${englishProficiency.id}</c:if>" method="post"	id="formEnglishProficiency" class="cmxform">
						<div class="header">English Proficiency</div>
						<div class="box">
							<span class="subHeader">English Fluency</span>
							<table class="indent">
								<tbody>
									<tr>
										<td>How well can you read and write English?</td>
										<td>
										 <select name="howWellReadWriteEnglish" 
											id="howWellReadWriteEnglish" style="width: 300px">  
									        <c:forEach var="item" items="${readWriteEnglishOptions}"> 
									            <option value="${item.value}" 
									            ${item.value==englishProficiency.howWellReadWriteEnglish ? 'selected' : ''}>
									            ${item.text}
									            </option>  
									        </c:forEach>  
									    </select>  
										</td>
									</tr>
									<tr>
										<td>How well do you speak English?</td>
										<td>
										<select name="howWellSpeakEnglish"
											id="howWellSpeakEnglish" style="width: 300px">
												 <c:forEach var="item" items="${speakEnglishOptions}">  
									            	 <option value="${item.value}" 
										             ${item.value==englishProficiency.howWellSpeakEnglish ? 'selected' : ''}>
										             ${item.text}
										             </option>   
									        	 </c:forEach>
										</select>
										</td>
									</tr>
									<tr>
										<td>How well do you understand spoken English?</td>
										<td>
										<select name="howWellUnderstandSpokenEnglish"
											id="howWellUnderstandSpokenEnglish" style="width: 300px">
												<c:forEach var="item" items="${understandEnglishOptions}">  
									            	<option value="${item.value}" 
										             ${item.value==englishProficiency.howWellUnderstandSpokenEnglish ? 'selected' : ''}>
										             ${item.text}
										             </option>    
									        	</c:forEach>
										</select>
										</td>
									</tr>
								</tbody>
							</table>
							<br> <span class="subHeader">Tests Taken</span> (not required) <br>
							<br>
							<table class="indent">
								<tbody>
									<tr>
										<td>TOEFL</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Year Taken</td>
										<td><select name="toeflYearTaken" id="toeflYearTaken"
											style="width: 60;">
												<c:forEach var="item" items="${toeflYearOptions}">  
									            	<option value="${item.value}" 
										             ${item.value==englishProficiency.toeflYearTaken ? 'selected' : ''}>
										             ${item.text}
										             </option> 
									        	</c:forEach>
										</select></td>
										<td>&nbsp;</td>
										<td>Score</td>
										<td><input type="text" name="toeflScore" 
										id="toeflScore" size="4" maxlength="10" value="${englishProficiency.toeflScore}"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>GRE</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Year Taken</td>
										<td><select name="greYearTaken" id="greYearTaken" style="width: 60;">
												<c:forEach var="item" items="${greYearOptions}">  
									            	<option value="${item.value}" 
										             ${item.value==englishProficiency.greYearTaken ? 'selected' : ''}>
										             ${item.text}
										             </option>   
									        	</c:forEach>
										</select></td>
									</tr>
									<tr>
										<td>Verbal Score</td>
										<td><input type="text" name="greVerbalScore" value="${englishProficiency.toeflScore}"
										id="greVerbalScore" size="4" maxlength="10"></td>
										<td>&nbsp;</td>
										<td>Percentile</td>
										<td><input type="text" name="greVerbalPercentile" value="${englishProficiency.greVerbalPercentile}"
										 id="greVerbalPercentile" size="4" maxlength="10"></td>
									</tr>
									<tr>
										<td>Quantitative Score</td>
										<td><input type="text" name="greQuantitativeScore"	value="${englishProficiency.greQuantitativeScore}"
										id="greQuantitativeScore" size="4" maxlength="10"></td>
										<td>&nbsp;</td>
										<td>Percentile</td>
										<td><input type="text" name="greQuantitativePercentile"	value="${englishProficiency.greQuantitativePercentile}"
										id="greQuantitativePercentile" size="4" maxlength="10"></td>
									</tr>
									<tr>
										<td>Analytical Score</td>
										<td><input type="text" name="greAnalyticalScore" value="${englishProficiency.greAnalyticalScore}"
										 id="greAnalyticalScore" size="4" maxlength="10"></td>
										<td>&nbsp;</td>
										<td>Percentile</td>
										<td><input type="text" name="greAnalyticalPercentile" value="${englishProficiency.greAnalyticalPercentile}"
										 id="greAnalyticalPercentile" size="4" maxlength="10"></td>
									</tr>
									<tr>
										<td colspan="4"></td>
										<td><input type="submit" value="Save English Fluency" style="height: 33px;font-weight: bold;font-size: 15px;"/></td>
									</tr>
								</tbody>
							</table>
							<br>
						</div>

					</form>

				</div>
				<div id="wrapper_right"></div>
			</div>
			<div id="footer">
				<div id="colophon">
					<div id="site-info">
						<a rel="home" title="Compro Online Application"	href="/ComproOnlineApplication">Compro Online Application</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>