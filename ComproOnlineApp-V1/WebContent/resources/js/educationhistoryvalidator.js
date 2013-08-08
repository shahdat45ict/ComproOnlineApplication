$(function(){
	// validate signup form on keyup and submit
	 $("#educationhistoryform").validate({
		rules: {
			whetherHighLevelEducation: "required",
			highestDegreeYear: "required",
			highestDegreeField: "required",
			highestDegree: "required",
			highestDegreeCountry: "required",
			gradingScaleUser: "required",
			highestDegreeGPA: "required",
			totalYearOfSecondaryEdu: "required",
			totalMonthOfSecondaryEdu: "required",
				
		},
		messages: {
		}
	});
});