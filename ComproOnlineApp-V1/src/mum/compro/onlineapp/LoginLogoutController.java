package mum.compro.onlineapp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginLogoutController {
	@Resource
	private RegistrationService registrationService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String email, String password) {
		int checkValidity = registrationService.checkUser(email, password);
		if(checkValidity == 1){
	        ModelAndView modelAndView = new ModelAndView();  
	        modelAndView.addObject("user", email);
			return "redirect:/application";
		}
		else
			return "/login";
	}	
}
