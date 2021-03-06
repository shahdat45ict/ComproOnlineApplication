package mum.compro.onlineapp.dashboard;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import mum.compro.onlineapp.RegistrationService;
import mum.compro.onlineapp.User;
import mum.compro.onlineapp.UserType;
import mum.compro.onlineapp.application.ApplicationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashBoardController {
	@Resource
	private ApplicationService applicationService;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			if(user.getUserType().equals(UserType.AdmissionStaff) || user.getUserType().equals(UserType.Administrator))
			{
				model.addAttribute("submittedApplications", applicationService.getSubmittedApplications());
				model.addAttribute("unSubmittedApplications", applicationService.getUnSubmittedApplications());
				return "dashboard";			
			}

		}
		return "redirect:/login";
	}
}
