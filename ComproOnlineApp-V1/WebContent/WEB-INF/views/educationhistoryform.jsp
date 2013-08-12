<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/js/educationhistoryvalidator.js" var="educationhistoryvalidator" />
<script type="text/javascript" src="${educationhistoryvalidator}"></script>
</head>
<body>

<div id="wrapper">
	<div id="wrapper_in">
		<div id="wrapper_middle">
			<div id="wrapper_left">
					<%String url = request.getContextPath() + "/application/saveeducationhistoryform"; %>
					<form:form action="<%=url %>" method="post" id="educationhistoryform" class="cmxform" name="educationhistoryform" commandName="form">  
					<form:hidden path="educationHistoryId"/>
					<div class="box">
						<!-- //Changes by Anupama Start-->

						<span class="subHeader">High School/Secondary Level
							Education</span>
						<table class="indent">

							<tr>
								<td colspan="2">
									<!-- <input type="radio" name="whetherHighLevelEducation" id="hSYes" value="Yes" checked> -->
									<form:radiobutton path="whetherHighLevelEducation" value="Yes"/>  
									YES, I graduated from high school.
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<!-- <input type="radio" name="whetherHighLevelEducation" id="hSNo" value="No"> -->
									<form:radiobutton path="whetherHighLevelEducation" value="No"/>  
									NO, I did not graduate from high school.
								</td>
							</tr>
						</table>
						<br />
						<!--Changes by Anupama End -->
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
									<!-- <select name="highestDegreeYear" id="highestDegreeYear" style="width: 100px;"> -->
									<form:select path="highestDegreeYear" id="highestDegreeYear" style="width: 100px;"> 
											<form:option value="">None</form:option>
											<form:option value="1">1 Year</form:option>
											<form:option value="2">2 Years</form:option>
											<form:option value="3">3 Years</form:option>
											<form:option value="4">4 Years</form:option>
											<form:option value="5">5+ Years</form:option>
									</form:select>
									<!-- </select> -->
								</td>
								<td>
									<!-- <select name="highestDegreeField" id="highestDegreeField" style="width: 250px;" onChange="setUpTextboxes(this,'otherField')"> -->
									<form:select path="highestDegreeField" id="highestDegreeField" style="width: 250px;">
											<form:option value="">None</form:option>
											<form:option value="CS">Computer Science</form:option>
											<form:option value="EE">Electronics Engineering</form:option>
											<form:option value="IT">Information Technology</form:option>
											<form:option value="other">Other</form:option>
									</form:select>
									<!-- </select> -->
								</td>
								<td>
									<!-- <select name="highestDegree" id="highestDegree" style="width: 250px" onChange="setUpTextboxes(this,'otherType');"> -->
									<form:select path="highestDegree" id="highestDegree" style="width: 250px;">
										<form:option value="">None</form:option>
										<form:option value="BS">Undergraduate/Bachelors</form:option>
										<form:option value="MS">Graduate/Masters</form:option>
										<form:option value="Diploma">Diploma</form:option>
										<form:option value="PhD">PhD</form:option>
										<form:option value="other">Other</form:option>
									</form:select>
									<!-- </select> -->
								</td>
							</tr>
							<!-- <tr>
								<td>&nbsp;</td>
								<td colspan="2">&nbsp;&nbsp; <span class="i">if
										'Other'</span> <input type="text" name="otherField" id="otherField"
									disabled style="width: 175px; background-color: #e0e0e0;"
									size="30" maxlength="40" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
									class="i">if 'Other'</span> <input type="text" name="otherType"
									id="otherType" disabled
									style="width: 169px; background-color: #e0e0e0;" size="30"
									maxlength="40" />
								</td>
							</tr> -->
						</table>
						<br />
						<br /> <span class="subHeader">Grade Point Average for
							Degree Indicated Above</span>
						<table class="indent">
							<tr>
								<td class="description">GPA information should be entered
									exactly as it appears on your transcripts, using the grading
									scale from your university. Please do not attempt to convert
									your grading scale to any other scale. If you incorrectly
									convert your GPA, it may result in the deferral of your
									application. For some countries, which use Division or Class
									(such as India or Pakistan), you should enter the final overall
									percentage from your courses. If you do not have your
									transcripts, please estimate your GPA as accurately as
									possible.</td>
							</tr>
						</table>
						<br />
						<table class="indent">
							<tr>
								<td>Country Degree was Granted:</td>
								<td>
									<!-- <select name="highestDegreeCountry" id="highestDegreeCountry" style="width: 200;" onChange="setUpTextboxes(this,'othDegrCountry');"> -->
									<form:select path="highestDegreeCountry" id="highestDegreeCountry" style="width: 200px;">
										<form:option value="Afghanistan">Afghanistan</form:option>
										<form:option value="Agentina">Agentina</form:option>
										<form:option value="Albania">Albania</form:option>
										<form:option value="Algeria">Algeria</form:option>
										<form:option value="Australia">Australia</form:option>
										<form:option value="Bahrain">Bahrain</form:option>
										<form:option value="Bangladesh">Bangladesh</form:option>
										<form:option value="Belgium">Belgium</form:option>
										<form:option value="Belize">Belize</form:option>
										<form:option value="Bolivia">Bolivia</form:option>
										<form:option value="Bulgaria">Bulgaria</form:option>
										<form:option value="Burundi">Burundi</form:option>
										<form:option value="Canada">Canada</form:option>
										<form:option value="Chile">Chile</form:option>
										<form:option value="China">China</form:option>
										<form:option value="Columbia">Columbia</form:option>
										<form:option value="Costa Rica">Costa Rica</form:option>
										<form:option value="Croatia">Croatia</form:option>
										<form:option value="Cuba">Cuba</form:option>
										<form:option value="Czech Republic">Czech Republic</form:option>
										<form:option value="Denmark">Denmark</form:option>
										<form:option value="Egypt">Egypt</form:option>
										<form:option value="El Salvador">El Salvador</form:option>
										<form:option value="Ethiopia">Ethiopia</form:option>
										<form:option value="Fiji">Fiji</form:option>
										<form:option value="Finland">Finland</form:option>
										<form:option value="France">France</form:option>
										<form:option value="Germany">Germany</form:option>
										<form:option value="Greece">Greece</form:option>
										<form:option value="Guatemala">Guatemala</form:option>
										<form:option value="Guyana">Guyana</form:option>
										<form:option value="Haiti">Haiti</form:option>
										<form:option value="Honduras">Honduras</form:option>
										<form:option value="Hungary">Hungary</form:option>
										<form:option value="Iceland">Iceland</form:option>
										<form:option value="India">India</form:option>
										<form:option value="Indonesia">Indonesia</form:option>
										<form:option value="Iran">Iran</form:option>
										<form:option value="Iraq">Iraq</form:option>
										<form:option value="Ireland">Ireland</form:option>
										<form:option value="Israel">Israel</form:option>
										<form:option value="Italy">Italy</form:option>
										<form:option value="Japan">Japan</form:option>
										<form:option value="Jordan">Jordan</form:option>
										<form:option value="Kenya">Kenya</form:option>
										<form:option value="Korea">Korea</form:option>
										<form:option value="Latvia">Latvia</form:option>
										<form:option value="Lebanon">Lebanon</form:option>
										<form:option value="Liberia">Liberia</form:option>
										<form:option value="Lithuania">Lithuania</form:option>
										<form:option value="Macedonia">Macedonia</form:option>
										<form:option value="Mayalsia">Mayalsia</form:option>
										<form:option value="Mexico">Mexico</form:option>
										<form:option value="Mongolia">Mongolia</form:option>
										<form:option value="Morocco">Morocco</form:option>
										<form:option value="Myanmar">Myanmar</form:option>
										<form:option value="Nepal">Nepal</form:option>
										<form:option value="Netherlands">Netherlands</form:option>
										<form:option value="New Zealand">New Zealand</form:option>
										<form:option value="Nicaragua">Nicaragua</form:option>
										<form:option value="Nigeria">Nigeria</form:option>
										<form:option value="Norway">Norway</form:option>
										<form:option value="Palestine">Palestine</form:option>
										<form:option value="Pakistan">Pakistan</form:option>
										<form:option value="Panama">Panama</form:option>
										<form:option value="Paraguay">Paraguay</form:option>
										<form:option value="Peru">Peru</form:option>
										<form:option value="Philippines">Philippines</form:option>
										<form:option value="Poland">Poland</form:option>
										<form:option value="Portugal">Portugal</form:option>
										<form:option value="Qatar">Qatar</form:option>
										<form:option value="Romania">Romania</form:option>
										<form:option value="Russia">Russia</form:option>
										<form:option value="Rwanda">Rwanda</form:option>
										<form:option value="Saudi Arabia">Saudi Arabia</form:option>
										<form:option value="Singapore">Singapore</form:option>
										<form:option value="Slovakia">Slovakia</form:option>
										<form:option value="Slovenia">Slovenia</form:option>
										<form:option value="South Africa">South Africa</form:option>
										<form:option value="Spain">Spain</form:option>
										<form:option value="Sri Lanka">Sri Lanka</form:option>
										<form:option value="Sudan">Sudan</form:option>
										<form:option value="Switzerland">Switzerland</form:option>
										<form:option value="Syria">Syria</form:option>
										<form:option value="Taiwan">Taiwan</form:option>
										<form:option value="Thailand">Thailand</form:option>
										<form:option value="Tunisia">Tunisia</form:option>
										<form:option value="Turkey">Turkey</form:option>
										<form:option value="UAE">UAE</form:option>
										<form:option value="UK">UK</form:option>
										<form:option value="Ukraine">Ukraine</form:option>
										<form:option value="Uruguay">Uruguay</form:option>
										<form:option value="USA">USA</form:option>
										<form:option value="Venezuela">Venezuela</form:option>
										<form:option value="Vietnam">Vietnam</form:option>
										<form:option value="Yugoslavia">Yugoslavia</form:option>
										<form:option value="Zaire">Zaire</form:option>
										<form:option value="Zambia">Zambia</form:option>
									</form:select>
									<!-- </select> -->
								</td>
							</tr>
							<tr>
								<td>Grading Scale Used:</td>
								<td>
									<!-- <select id="gradingScaleUser" name="gradingScaleUser" style="width: 200;"> -->
									<form:select path="gradingScaleUser" id="gradingScaleUser" style="width: 200px;">
											<form:option value="F-A">F to A (A is best)</form:option>
											<form:option value="0-4">0 to 4 (4 is best)</form:option>
											<form:option value="0-5">0 to 5 (5 is best)</form:option>
											<form:option value="5-1">5 to 1 (1 is best)</form:option>
											<form:option value="0-10">0 to 10 (10 is best)</form:option>
											<form:option value="0-20">0 to 20 (20 is best)</form:option>
											<form:option value="0-100">0 to 100 (percentage)</form:option>
									</form:select>
									<!-- </select> -->
								</td>
							</tr>
							<tr>
								<td>GPA for selected Degree:<br /> <span class="note">
										This MUST be in the range of the selected scale above! </span>
								</td>
							
									
								<td><form:input path="highestDegreeGPA" id="highestDegreeGPA"
									size="5" maxlength="10"/></td>  
							</tr>

						</table>
						<br />
						<br /> 
						<br />
						<br /> <span class="subHeader">Total Years / Months of Post
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
								<!-- <select name="totalYearOfSecondaryEdu" id="totalYearOfSecondaryEdu" style="width: 40px"> -->
								<form:select path="totalYearOfSecondaryEdu" id="totalYearOfSecondaryEdu" style="width: 40px;">
										<form:option value="0">0</form:option>
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5+</form:option>
								</form:select>
								<!-- </select> -->
									&nbsp;&nbsp; Months: 
								<!-- <select name="totalMonthOfSecondaryEdu" id="totalMonthOfSecondaryEdu" style="width: 40px"> -->
								<form:select path="totalMonthOfSecondaryEdu" id="totalMonthOfSecondaryEdu" style="width: 40px;">
										<form:option value="0">0</form:option>
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5</form:option>
										<form:option value="6">6</form:option>
										<form:option value="7">7</form:option>
										<form:option value="8">8</form:option>
										<form:option value="9">9</form:option>
										<form:option value="10">10</form:option>
										<form:option value="11">11</form:option>
								</form:select>
								<!-- </select> -->
								<br />
								<br />
								</td>
							</tr>
						</table>
						<br />
					</div>
					<br />
					<br />
					<input type="submit" value="Save" class="button" style="margin-left: 100px;"/>
				</form:form>
<script type="text/javascript">
function saveForm(){
	//var url="saveeducationhistoryform";
    //document.educationhistoryform.action = url;
	document.educationhistoryform.submit();
	}

</script>
			</div>
			<div id="wrapper_right"></div>
		</div>
		
	</div>
</div>
</body>
</html>
