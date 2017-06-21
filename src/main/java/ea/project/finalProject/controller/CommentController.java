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
	public String addComment(String content, int postId, int userId ) {

		Comment comment = new Comment(new Date(),new Date(),content,userService.getUser(userId), postService.getPost(postId) );
			commentService.addComment(comment);
		
		return "redirect:/home";

	}

	@PostMapping(value = "/deleteComment")
	public String deleteComment(String userid, int commentid) {
		commentService.deleteCommentById(commentid);
		return "redirect:/home";

	}

	@PostMapping(value = "/updateComment")
	public String updateComment(int commentid, String content, Model model) {
		Comment comment = commentService.getComment(commentid);
		comment.setUpdatedDate(new Date());
		comment.setContent(content);
		// comment.setUpdatedDate(new Date());
		commentService.updateComment(comment);
		return "redirect:/home";

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
