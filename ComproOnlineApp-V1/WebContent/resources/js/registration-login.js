$(function(){
//validate forgot password form on keyup and submit
	 $("#formForgotPassword").validate({
	 	rules: {
	 		email: "required",						
	 	//	password:"required"	 
	 	},
	 	messages: {
	 		email: "Please enter your valid/registered email",
	 	//	password: "Please enter your password"
	 	}
	 });

	 //validate  change password form on keyup and submit
	 $("#formChangePassword").validate({
	 	 rules:{
	 		oldpassword:{
	 			 required:true,
	 			 remote: {
	 					url: "checkOldPassword",
	 					type: "GET",
	 					data: {
	 						oldPassword: function() {
	 							return  $('#oldPassword').val();
	 						}
	 					}
	 				}
	 		 },
	 		 
	 		 newpassword:{
	 			 required:true,
	 			 minlength:6
	 		 },
	 		 confirmpassword:{
	 			 required:true,
	 			 minlength:6,
	 			 equalTo:"#newPassword"
	 			 
	 		 }
	 	 },
	 	 messages:{
	 		oldpassword:{
	 			 required: "Please enter your current password",
	 			remote: "wrong password"
	 		 },
	 		 newpassword:{
	 			 required:"Pleaase enter a new password",
	 			 minlength:"Please your password must be at least six characters long"
	 		 },
	 		 confirmpassword:{
	 			 required:"Please re-enter your new password",
	 			 minlength:"Please your password must be at least six characters long",
	 			 equalTo:"Please enter the same password as new password"
	 			 
	 		 }
	 		 
	 	 }
	 	 
	 });
});
	 
	 