package sessioninview;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoaderListener;

import com.titan.util.EmailService;

@Controller
public class RegistrationController {
	@Resource
	private BlogService blogService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(User user) {
		blogService.addNewUser(user);
		EmailService service =(EmailService) ContextLoaderListener.getCurrentWebApplicationContext ().getBean ("emailService");
		service.sendEmailTo(user);
		return "redirect:/admin/posts";
	}	
	
}
