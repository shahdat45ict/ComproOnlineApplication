package mum.compro.onlineapp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mum.compro.mail.util.MailUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
	@Resource
	private RegistrationService registrationService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}
	@RequestMapping(value = "registration/activated", method = RequestMethod.GET)
	public String activated(@RequestParam("userid") long userid) {
		
		registrationService.activated(userid);
		
		return "redirect:/login";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(User user, HttpServletRequest request) {
		String email = request.getParameter("email");
		User userdb = registrationService.getUserbyEmail(email);
		if (userdb == null) {
			Long userId = registrationService.addNewUser(user);
			String url = request.getRequestURL()  + "/activated?userid=" + userId;
			String fName = request.getParameter("firstName");
			MailUtil.sendEmailTo(email, "Your account is created", "Dear "
					+ fName
					+ ", Please activate your account " +  url);
			return "redirect:/login";
		} else
			return "registFail";
	}

}
