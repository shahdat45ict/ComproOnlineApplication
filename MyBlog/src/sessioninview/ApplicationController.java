package sessioninview;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class ApplicationController {
	@Resource
	private BlogService blogService;
	
	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public String application() {
		return "application";
	}
		
}
