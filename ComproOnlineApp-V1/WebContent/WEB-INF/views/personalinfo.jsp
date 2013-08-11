<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<d:url value="/resources/js/jquery.validate.min.js" var="validatorURL" />
<d:url value="/resources/js/personal-info.js" var="jsURL" />
<script type="text/javascript" src="${validatorURL}"></script>
<script type="text/javascript" src="${jsURL}"></script>
</head>
<body>
<div id="wrapper">
<div id="wrapper_in">
<div id="wrapper_middle">
<div id="wrapper_left">
    <form action="application/personalinfo<d:if test='${not empty personalInfo.id}'>/${personalInfo.id}</d:if>" method="post" id="formPersonalInfo" class="cmxform">
		<table>
			<tr>
				<td><label for="txtFirstName">First Name(s):</label></td>
				<td><input id="txtFirstName" name="firstName" type="text" value="${personalInfo.firstName}" /></td>
			</tr>
			<tr>
				<td><label for="txtLastName">Middle Name(s):</label></td>
				<td><input id="txtMiddleName" type="text" name="middleName" value="${personalInfo.middleName}" /></td>
			</tr>
			<tr>
				<td><label for="txtSurName">(Family) Legal Surname(s):</label></td>
				<td><input id="txtSurName" type="text" name="surName" value="${personalInfo.surName}" /></td>
			</tr>
			<tr>
				<td><label for="selectSex">Sex:</label></td>
				<td>
				 <select id="selectSex" name="sex">
				   <option value="male" <d:if test="${personalInfo.sex == 'male'}">selected="selected"</d:if>>Male</option>
				   <option value="female" <d:if test="${personalInfo.sex == 'female'}">selected="selected"</d:if>>Female</option>
				 </select>
				</td>
			</tr>

		    <tr>
				<td><label for="selectMaritalStatus">Marital Status:</label></td>
				<td>
				 <select id="selectMaritalStatus" name="maritalStatus">
				   <option value="single" <d:if test="${personalInfo.maritalStatus == 'single'}">selected="selected"</d:if>>Single</option>
				   <option value="married" <d:if test="${personalInfo.maritalStatus == 'married'}">selected="selected"</d:if>>Married</option>
				 </select>
				</td>
			</tr>
            <tr>
              <td><label for="selectCountryOfCitizenship">Country of Citizenship:</label></td>
              <td>
               <select name="countryOfCitizenship" id="selectCountryOfCitizenship">
                   <option value="">Select a Country</option>
				   <d:forEach items="${countryList}" var="country">
				       <option value="${country}" <d:if test="${personalInfo.countryOfCitizenship == country}">selected="selected"</d:if>>${country}</option>
				   </d:forEach>
				</select>
              </td>
            </tr>
            <tr>
              <td><label for="selectCountryOfBirth">Country of Birth:</label></td>
              <td>
               <select name="countryOfBirth" id="selectCountryOfBirth">
                   <option value="">Select a Country</option>
				   <d:forEach items="${countryList}" var="country">
				       <option value="${country}" <d:if test="${personalInfo.countryOfBirth == country}">selected="selected"</d:if>>${country}</option>
				   </d:forEach>
				</select>
              </td>
            </tr>
            <tr>
				<td><label for="txtDateOfBirth">Date of Birth:</label></td>
				<td>
				    <d:set var="dateParts" value="${fn:split(personalInfo.dateOfBirth, '-')}" />
				    
					<select name="month">
				    <option value="01" <d:if test="${dateParts[1] == 01}">selected="selected"</d:if>>January</option>
				    <option value="02" <d:if test="${dateParts[1] == 02}">selected="selected"</d:if>>February</option>
				    <option value="03" <d:if test="${dateParts[1] == 03}">selected="selected"</d:if>>March</option>
				    <option value="04" <d:if test="${dateParts[1] == 04}">selected="selected"</d:if>>April</option>
				    <option value="05" <d:if test="${dateParts[1] == 05}">selected="selected"</d:if>>May</option>
				    <option value="06" <d:if test="${dateParts[1] == 06}">selected="selected"</d:if>>June</option>
				    <option value="07" <d:if test="${dateParts[1] == 07}">selected="selected"</d:if>>July</option>
				    <option value="08" <d:if test="${dateParts[1] == 08}">selected="selected"</d:if>>August</option>
				    <option value="09" <d:if test="${dateParts[1] == 09}">selected="selected"</d:if>>September</option>
				    <option value="10" <d:if test="${dateParts[1] == 10}">selected="selected"</d:if>>October</option>
				    <option value="11" <d:if test="${dateParts[1] == 11}">selected="selected"</d:if>>November</option>
				    <option value="12" <d:if test="${dateParts[1] == 12}">selected="selected"</d:if>>December</option>
				  </select>
				
				  <select name="day">
				    <d:forEach begin="1" end="31" var="day">
				      <option value="${day}" <d:if test="${dateParts[2] == day}">selected="selected"</d:if>><d:out value="${day}"/></option>
				    </d:forEach>
				  </select>
				
				  <select name="year">
				    <d:forEach begin="1950" end="2008" var="year">
				      <option value="${year}" <d:if test="${dateParts[0] == year}">selected="selected"</d:if>><d:out value="${year}"/></option>
				    </d:forEach>
				  </select>
				</td>
			</tr>
			<tr>
				<td><label for="txtEmail">Email:</label></td>
				<td><input id="txtEmail" type="text" name="email" value="${personalInfo.email}" />
				</td>
			</tr>
			<tr>
				<td><label for="txtSkypeId">Skype ID:</label></td>
				<td><input id="txtSkypeId" type="text" name="skypeId" value="${personalInfo.skypeId}" />
				</td>
			</tr>
			
			<tr>
				<td><label for="txtPhone">Phone Number:</label></td>
				<td><input id="txtPhone" type="text" name="phone" value="${personalInfo.phone}" /></td>
			</tr>
			
			<tr>
				<td><label for="txtCity">City you live in now:</label></td>
				<td><input id="txtCityLiveIn" type="text" name="cityLiveIn" value="${personalInfo.cityLiveIn}" /></td>
			</tr>
			
			<tr>
				<td><label for="selectCountryLiveIn">Country you live in now:</label></td>
				<td>
				 <select name="countryLiveIn" id="selectCountryLiveIn">
				   <option value="">Select a Country</option>
				   <d:forEach items="${countryList}" var="country">
				       <option value="${country}" <d:if test="${personalInfo.countryLiveIn == country}">selected="selected"</d:if>>${country}</option>
				   </d:forEach>
				 </select>
				</td>
			</tr>			
		</table>
		<input type="submit" value="Submit" class="button" style="margin-left:158px;" />		
	</form>
</div>
<div id="wrapper_right">

</div>	
</div>
</div>	
</div>
</body>
</html>	