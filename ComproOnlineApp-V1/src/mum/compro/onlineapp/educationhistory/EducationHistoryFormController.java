package mum.compro.onlineapp.educationhistory;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import mum.compro.onlineapp.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/application")
public class EducationHistoryFormController {
	@Resource
	private EducationHistoryService educationHistoryService;
	
	@RequestMapping(value = "/educationhistoryform", method = RequestMethod.GET)
	public String educationhistoryform(Model model,HttpSession session) {
		EducationHistoryForm educationHistoryForm ;
		User user =(User) session.getAttribute("user");
		if(user != null){
			educationHistoryForm = educationHistoryService.getEducationHistoryFormByUser(user);
			model.addAttribute("form", educationHistoryForm);
			String disposition = educationHistoryForm.getDisposition();
			if("save".equalsIgnoreCase(disposition)){
				return "educationhistoryform";
			}else if("submit".equalsIgnoreCase(disposition)){
				return "vieweducationhistoryform";
			}else{
				return "educationhistoryform";
			}
		}else{
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/saveeducationhistoryform", method = RequestMethod.POST)
	public String saveEducationHistoryform(EducationHistoryForm form ,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user != null){
			form.setUser(user);
			educationHistoryService.saveOrUpdateEducationHistoryForm(form);
			return "redirect:/application";
		}else{
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/submiteducationhistoryform", method = RequestMethod.POST)
	public String submitEducationHistoryform(EducationHistoryForm form ,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user != null){
			form.setUser(user);
			educationHistoryService.submitEducationHistoryForm(form);
			return "redirect:/application";
		}else{
			return "redirect:/";
		}
	}

	public EducationHistoryService getEducationHistoryService() {
		return educationHistoryService;
	}

	public void setEducationHistoryService(
			EducationHistoryService educationHistoryService) {
		this.educationHistoryService = educationHistoryService;
	}	
	
}
