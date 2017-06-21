package ea.project.finalProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ea.project.finalProject.model.Post;
import ea.project.finalProject.model.PostProxy;
import ea.project.finalProject.model.User;
import ea.project.finalProject.service.CommentService;
import ea.project.finalProject.service.PostService;
import ea.project.finalProject.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;

	 
	
	 @Autowired
	private UserService userService;
	 
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String addPost(Model model){
		System.out.println("uuuuuuu");
		model.addAttribute("posts",this.postService.getAllPost());
		
		
		List<Post> posts= (List<Post>) this.postService.getAllPost();
		List<PostProxy> poxyposts = new ArrayList<PostProxy>();
		
		
		for(Post post1: posts)
		{
			boolean 	status ;
			status=post1.getLikes().contains(userService.getUser(2));
			System.out.println("status" + status);
			poxyposts.add(new PostProxy(post1, status));
			
			for(PostProxy p: poxyposts)
			{
				System.out.println(p.getStatus());
			}
			
		}

		model.addAttribute("posts",poxyposts);

		
		
		
		
		return "home";
	}
	
	
	@RequestMapping(value="/likePost", method=RequestMethod.POST)
	public String likePost(int userid, int postid, Model model){
		
		User user= userService.getUser(userid);
		Post  post = postService.getPost(postid);
		post.getLikes().add(user);
		postService.updatePost(post);
		model.addAttribute("likepost",postService.doUserLike(userid, postid));
		return "redirect:/home";
	}
	
	
	@RequestMapping(value="/unLikePost", method=RequestMethod.POST)
	public String unLikePost(int userid, int postid, Model model){
		
		User user= userService.getUser(userid);
		Post  post = postService.getPost(postid);
		post.getLikes().remove(user);
		postService.updatePost(post);
		//model.addAttribute("likepost",postService.doUserLike(userid, postid));
		return "redirect:/home";
	}

	
	@RequestMapping(value="/deletePost", method=RequestMethod.POST)
	public String deletePost(int postid, Model model){
		

		postService.deletePostById(postid);
		//postService.deletePost(postService.getPost(postid));

		return "redirect:/home";
	}


	@RequestMapping(value="/updatePost", method=RequestMethod.POST)
	public String updatePost(int postid, String content, Model model){
		

		Post post=postService.getPost(postid);
		post.setContent(content);
		postService.updatePost(post);

		return "redirect:/home";
	}

	
	
	//updatePost

}
