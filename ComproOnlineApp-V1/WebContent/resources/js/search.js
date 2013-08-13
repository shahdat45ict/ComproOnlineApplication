$(function(){
	// validate Search form on keyup and submit
	 $("#formSearch").validate({
		rules: {
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			email: "Please enter a valid email"
		}
	});
});