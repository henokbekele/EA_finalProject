package ea.project.finalProject.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ea.project.finalProject.model.Post;
import ea.project.finalProject.model.User;
import ea.project.finalProject.service.PostService;
import ea.project.finalProject.service.UserService;

@Controller()
@RequestMapping("/app/post")
@SessionAttributes("user")
public class PostController {
	@Autowired
	private PostService postService;
	
	 @Autowired
	private UserService userService;
 	
	@RequestMapping("/")
	public String home(){
		return "home";
	}


	@RequestMapping(value="/addpost", method=RequestMethod.POST)
	public String addPost(String title, String content,ModelMap model){
		Post  post= new Post(title,new Date(), new Date(), content, userService.getUser(1));
		this.postService.addPost(post);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String removePost(Post post,ModelMap model){
		this.postService.deletePost(post);
		return "redirect:/posts";
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String addPost(@RequestParam int postId,ModelMap model){
		model.addAttribute("post",this.postService.getPost(postId));
		return "post";
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public String addPost(ModelMap model){
		model.addAttribute("posts",this.postService.getAllPost());
		return "redirect:/home";
	}
	
}
