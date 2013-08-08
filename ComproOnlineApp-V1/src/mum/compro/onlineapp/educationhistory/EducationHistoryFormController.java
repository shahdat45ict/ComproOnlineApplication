package mum.compro.onlineapp.educationhistory;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping(value = "/educationhistoryform")
public class EducationHistoryFormController {
	@Resource
	private EducationHistoryService educationHistoryService;
	
	@RequestMapping(value = "/educationhistoryform", method = RequestMethod.GET)
	public String registration(Model model,HttpSession session) {
		EducationHistoryForm educationHistoryForm = new EducationHistoryForm();
		educationHistoryForm.setHighestDegreeGPA("100");
		educationHistoryForm.setWhetherHighLevelEducation("Yes");
		educationHistoryForm.setHighestDegreeYear("5");
		educationHistoryForm.setHighestDegreeField("IT");
		educationHistoryForm.setHighestDegreeCountry("China");
		model.addAttribute("form", educationHistoryForm);
		return "educationhistoryform";
	}
	
	@RequestMapping(value = "/saveeducationhistoryform", method = RequestMethod.POST)
	public String saveEducationHistoryform(EducationHistoryForm form ) {
		educationHistoryService.saveOrUpdateEducationHistoryForm(form);
		return "redirect:/";
	}
	@RequestMapping(value = "/submiteducationhistoryform", method = RequestMethod.POST)
	public String submitEducationHistoryform(EducationHistoryForm form ) {
		educationHistoryService.submitEducationHistoryForm(form);
		return "redirect:/";
	}

	public EducationHistoryService getEducationHistoryService() {
		return educationHistoryService;
	}

	public void setEducationHistoryService(
			EducationHistoryService educationHistoryService) {
		this.educationHistoryService = educationHistoryService;
	}	
	
}
