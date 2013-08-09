$(function(){
	// validate Personal Info form on keyup and submit
	 $("#formPersonalInfo").validate({
		rules: {
			firstName: "required",
			surName: "required",
			countryOfCitizenship: "required",
			countryOfBirth: "required",
			countryLiveIn: "required",
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			firstName: "Please enter first name",
			surName: "Please enter Sur Name",
			countryOfCitizenship: "Please select your country of citizenship",
			countryLiveIn: "Please select country you live in",
			email: "Please enter your email"
		}
	});
});