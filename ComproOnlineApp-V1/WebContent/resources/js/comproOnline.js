$(function(){
	// validate login form on keyup and submit
	 $("#formLogin").validate({
		rules: {
			email: "required",						
			password:"required"	 
		},
		messages: {
			email: "Please enter your email",
			password: "Please enter your password"
		}
	});
	 
	// validate signup form on keyup and submit
	 $("#formRegistration").validate({
		rules: {
			firstName: "required",
			lastName: "required",			
			password: {
				required: true,
				minlength: 6
			},
			confirmPassword: {
				required: true,
				minlength: 6,
				equalTo: "#txtPassword"
			},
			email: {
				required: true,
				email: true
			}			
		},
		messages: {
			firstName: "Please enter your firstname",
			lastName: "Please enter your lastname",			
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 6 characters long"
			},
			confirmPassword: {
				required: "Please provide a password",
				minlength: "Your password must be at least 6 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address"
		}
	});
});