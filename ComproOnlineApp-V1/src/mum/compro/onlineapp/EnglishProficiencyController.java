package mum.compro.onlineapp;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EnglishProficiencyController {
	@Resource
	private EnglishProficiencyService englishProficiencyService;

	@RequestMapping(value = "/englishproficiency", method = RequestMethod.GET)
	public String englishProficiency(Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user!=null){
			long id = user.getId();
			EnglishProficiency ep = englishProficiencyService.getEnglishProficiency(id);
			if(ep!=null){
				model.addAttribute("englishProficiency", ep);	
			}
			model.addAttribute("readWriteEnglishOptions", englishProficiencyService.getReadWriteEnglishOptions());
			model.addAttribute("speakEnglishOptions", englishProficiencyService.getSpeakEnglishOptions());
			model.addAttribute("understandEnglishOptions", englishProficiencyService.getUnderstandSpokenEnglishOptions());
			model.addAttribute("toeflYearOptions", englishProficiencyService.getToeflYearOptions());
			model.addAttribute("greYearOptions", englishProficiencyService.getGreYearOptions());
			return "englishproficiency";
		}
		else{
			return "login";
		}
	}

	@RequestMapping(value = "/englishproficiency", method = RequestMethod.POST)
	public String englishProficiency(EnglishProficiency englishProficiency) {
		englishProficiencyService.addNewEnglishProficiency(englishProficiency);
		return "redirect:/";
	}	

	@RequestMapping(value="/englishproficiency/{id}", method=RequestMethod.POST)
	public String update(EnglishProficiency englishProficiency, @PathVariable int id) {
		englishProficiencyService.updateEnglishProficiency(englishProficiency);
		return "redirect:/";
	}

}
