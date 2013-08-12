package mum.compro.onlineapp;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import mum.compro.onlineapp.application.Application;
import mum.compro.onlineapp.application.ApplicationService;
import mum.compro.onlineapp.educationhistory.EducationHistoryForm;
import mum.compro.onlineapp.educationhistory.EducationHistoryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class ApplicationController {
	@Resource
	private ApplicationService applicationService;
	@Resource
	private RegistrationService registrationService;
	@Resource
	private EnglishProficiencyService englishProficiencyService;
	@Resource
	private PersonalInfoService personalInfoService;
	@Resource
	private EducationHistoryService educationHistoryService;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public String application(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			// personal information
			Application application = user.getApplication();			
			long id = user.getId();
			PersonalInfo personalInfo = personalInfoService.getPersonalInfo(application.getPersonalInfo().getId());
			if (personalInfo != null)
				model.addAttribute("personalInfo", personalInfo);
			model.addAttribute("countryList", personalInfoService.getAllCountryList());

			// english proficiency
			EnglishProficiency ep = englishProficiencyService
					.getEnglishProficiency(application.getEnglishProficiency().getId());
			if (ep != null) {
				model.addAttribute("englishProficiency", ep);
			}
			model.addAttribute("readWriteEnglishOptions",
					englishProficiencyService.getReadWriteEnglishOptions());
			model.addAttribute("speakEnglishOptions",
					englishProficiencyService.getSpeakEnglishOptions());
			model.addAttribute("understandEnglishOptions",
					englishProficiencyService
							.getUnderstandSpokenEnglishOptions());
			model.addAttribute("toeflYearOptions",
					englishProficiencyService.getToeflYearOptions());
			model.addAttribute("greYearOptions",
					englishProficiencyService.getGreYearOptions());
			// english proficiency
			// education history
			EducationHistoryForm educationHistoryForm = educationHistoryService
					.getEducationHistoryFormByUser(user);
			model.addAttribute("form", educationHistoryForm);
			// end
			return "application";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/application/submitapplication", method = RequestMethod.POST)
	public String submitApplication(HttpSession session) {
		User user = (User) session.getAttribute("user");
		applicationService.submitApplication(user);
		return "redirect:/application";
	}
	
	@RequestMapping(value = "/application-detail/{id}", method = RequestMethod.GET)
	public String applicationDetail(@PathVariable long id, Model model) {
		Application application = applicationService.getApplication(id);
		model.addAttribute("application", application);
		return "applicationdetail";
	}
	

	@RequestMapping(value = "/application/setapplicationdisposition/{id}", method = RequestMethod.POST)
	public String setApplicationDisposition(@PathVariable long id, String disposition) {
		applicationService.setApplicationDisposition(id, disposition);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/application/set-application-unsubmitted/{id}", method = RequestMethod.POST)
	public String setApplicationUnsubmitted(@PathVariable long id, String status) {
		applicationService.setApplicationUnsubmitted(id, status);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/search-applicant", method = RequestMethod.POST)
	public String searchApplicant(String email, Model model) {
	    User user = registrationService.getUserbyEmail(email);
		Application application = applicationService.searchApplicant(user.getId());
		model.addAttribute("application", application);
		return "applicationdetail";
	}	

}
