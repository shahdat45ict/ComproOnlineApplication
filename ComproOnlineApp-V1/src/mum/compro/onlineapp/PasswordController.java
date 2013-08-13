package mum.compro.onlineapp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class PasswordController {

	@Resource
	private PasswordService passwordService;

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword() {
		return "changePassword";

	}

	@RequestMapping(value = "/checkOldPassword", method = RequestMethod.GET)
	@ResponseBody
	public String checkOldPassword(@RequestParam String oldPassword,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		return passwordService.checkPassword(oldPassword, user.getEmail());
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest request, HttpSession session) {
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		User userdb = (User) session.getAttribute("user");
		
			if(newpassword.equals(confirmpassword)){
			  passwordService.updatePassword(newpassword, userdb);
			  return "redirect:/";
			}
		
		   
		return "changePassword";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "forgotPassword";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String forgotPassword(HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		// MailUtil.sendEmailTo(email, "reset password", " 1234");
		// User userb=(User) session.getAttribute("user");
		User user = passwordService.getUserbyEmail(email);

		if (user != null) {
			return "login";
		} else
			return "login";
	}

}
