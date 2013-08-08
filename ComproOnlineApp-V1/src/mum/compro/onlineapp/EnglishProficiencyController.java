package mum.compro.onlineapp;

import javax.annotation.Resource;

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
	public String englishProficiency(Model model) {
		model.addAttribute("readWriteEnglishOptions", englishProficiencyService.getReadWriteEnglishOptions());
		model.addAttribute("speakEnglishOptions", englishProficiencyService.getSpeakEnglishOptions());
		model.addAttribute("understandEnglishOptions", englishProficiencyService.getUnderstandSpokenEnglishOptions());
		model.addAttribute("toeflYearOptions", englishProficiencyService.getToeflYearOptions());
		model.addAttribute("greYearOptions", englishProficiencyService.getGreYearOptions());
		return "englishproficiency";
	}
	
	@RequestMapping(value = "/englishproficiency", method = RequestMethod.POST)
	public String englishProficiency(EnglishProficiency englishProficiency) {
		englishProficiencyService.addNewEnglishProficiency(englishProficiency);
		return "redirect:/";
	}	
	
	@RequestMapping(value="/englishproficiency/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {		
		model.addAttribute("englishProficiency", englishProficiencyService.getEnglishProficiency(id));		
		model.addAttribute("readWriteEnglishOptions", englishProficiencyService.getReadWriteEnglishOptions());
		model.addAttribute("speakEnglishOptions", englishProficiencyService.getSpeakEnglishOptions());
		model.addAttribute("understandEnglishOptions", englishProficiencyService.getUnderstandSpokenEnglishOptions());
		model.addAttribute("toeflYearOptions", englishProficiencyService.getToeflYearOptions());
		model.addAttribute("greYearOptions", englishProficiencyService.getGreYearOptions());
		return "englishproficiency";
	}
	
	@RequestMapping(value="/englishproficiency/{id}", method=RequestMethod.POST)
	public String update(EnglishProficiency englishProficiency, @PathVariable int id) {
		englishProficiencyService.updateEnglishProficiency(englishProficiency);
		return "redirect:/";
	}
	
}
