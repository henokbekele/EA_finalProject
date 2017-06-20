package ea.project.finalProject.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ea.project.finalProject.model.Comment;
import ea.project.finalProject.model.User;
import ea.project.finalProject.service.CommentService;
import ea.project.finalProject.service.PostService;
import ea.project.finalProject.service.UserService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private PostService postService;
	
	 @Autowired
	private UserService userService;
	/*
	@GetMapping(value = "/home")
	public String gethome( ) {

		return "home";

	}
*/
	
	@PostMapping(value = "/addcomment")
	public String addComment(String content, int postId ) {

		Comment comment = new Comment(new Date(),new Date(),content,userService.getUser(1), postService.getPost(postId) );
			commentService.addComment(comment);
		
		return "redirect:/home";

	}

	@PostMapping(value = "/deletecomment")
	public String deleteComment(Comment comment, Model model) {
		commentService.deleteComment(comment);
		return "redirect:/comments";

	}

	@PostMapping(value = "/updatecomment")
	public String updateComment(Comment comment, Model model) {
		comment.setUpdatedDate(new Date());
		commentService.updateComment(comment);
		return "redirect:/comments";

	}

	@PostMapping(value = "/likecomment")
	public String likeComment(User user, Comment comment, Model model) {

		commentService.likeComment(user, comment);
		return "redirect:/comments";

	}

	@PostMapping(value = "/unlikecomment")
	public String unLikeComment(User user, Comment comment, Model model) {

		commentService.unLikeComment(user, comment);
		return "redirect:/comments";

	}

}
