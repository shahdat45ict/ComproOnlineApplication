package mum.compro.onlineapp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mum.compro.mail.util.MailUtil;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
	@Resource
	private RegistrationService registrationService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(User user, HttpServletRequest request) {

		String email = request.getParameter("email");
		User userdb = registrationService.getUserbyEmail(email);
		if (userdb == (null)) {
			registrationService.addNewUser(user);
			String fName = request.getParameter("firstName");
			MailUtil.sendEmailTo(email, "Your account is created", "Dear "
					+ fName
					+ ", You can now log in to complete your application");
			return "redirect:/login";
		} else
			return "registFail";
	}

}
