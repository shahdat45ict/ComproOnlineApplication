package sessioninview;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
	@Resource
	private BlogService blogService;

/*	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/posts";
	}*/
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", blogService.getPostsForIndex());
		return "index";
	}
	
/*	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password) {
		int checkValidity = blogService.checkUser(username, password);
		if(checkValidity == 1)
		  return "redirect:/admin/posts";
		else
			return "/login";
	}	*/
	
	@RequestMapping(value = "/admin/addnewpost", method = RequestMethod.GET)
	public String addnewpost() {
		return "addPost";
	}

	@RequestMapping(value = "/admin/posts", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("posts", blogService.getPosts());
		return "postList";
	}

	@RequestMapping(value = "/admin/posts", method = RequestMethod.POST)
	public String add(Post post) {
		blogService.addNewPost(post);
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/admin/comments", method = RequestMethod.POST)
	public String addComment(Comment comment) {
		blogService.addNewComment(comment);
		return "redirect:/index";
	}

	@RequestMapping(value = "/admin/posts/{id}", method = RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		Post p = blogService.getPost(id);
		model.addAttribute("post", blogService.getPost(id));
		model.addAttribute("status", p.getStatus());
		return "updatePost";
	}

	@RequestMapping(value = "/admin/posts/{id}", method = RequestMethod.POST)
	public String update(Post post, @PathVariable long id) {
		blogService.updatePost(post);
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String getPostDetail(@PathVariable long id, Model model) {
		model.addAttribute("post", blogService.getPost(id));
		return "postDetail";
	}

	@RequestMapping(value = "/admin/posts/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable long id) {
		blogService.deletePost(id);
		return "redirect:/admin/posts";
	}
}
