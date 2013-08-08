package mum.compro.onlineapp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PersonalInfoController {
	
	@Resource
	private PersonalInfoService personalInfoService;
	
	@RequestMapping(value = "/application/personalinfo", method = RequestMethod.GET)
	public String personalinfo(Model model) {
		PersonalInfo personalInfo = personalInfoService.getPersonalInfo(1);
		if(personalInfo != null)
			model.addAttribute("personalInfo", personalInfoService.getPersonalInfo(1));
		model.addAttribute("countryList", personalInfoService.getAllCountryList());
		return "personalinfo";
	}

	
	@RequestMapping(value = "/application/personalinfo", method = RequestMethod.POST)
	public String registration(@RequestParam("month") String month, @RequestParam("day") String day, @RequestParam("year") String year, PersonalInfo personalinfo) {
		personalInfoService.addNewPersonalInfo(personalinfo, month, day, year);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/application/personalinfo/{id}", method = RequestMethod.POST)
	public String update(PersonalInfo personalInfo, @PathVariable long id, @RequestParam("month") String month, @RequestParam("day") String day, @RequestParam("year") String year) {
		personalInfoService.updatePersonalInfo(personalInfo, month, day, year);
		return "redirect:/login";
	}
}
