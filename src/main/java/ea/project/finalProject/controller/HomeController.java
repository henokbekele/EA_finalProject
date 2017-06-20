package ea.project.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ea.project.finalProject.service.CommentService;
import ea.project.finalProject.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String addPost(Model model){
		System.out.println("uuuuuuu");
		model.addAttribute("posts",this.postService.getAllPost());
		return "home";
	}
	

}
