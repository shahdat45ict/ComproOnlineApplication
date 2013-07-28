package sessioninview;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginLogoutController {
	@Resource
	private BlogService blogService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String email, String password) {
		int checkValidity = blogService.checkUser(email, password);
		if(checkValidity == 1)
		  return "redirect:/admin/posts";
		else
			return "/login";
	}	
}
