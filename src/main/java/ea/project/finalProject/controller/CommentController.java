package ea.project.finalProject.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ea.project.finalProject.model.Comment;
import ea.project.finalProject.model.User;
import ea.project.finalProject.service.CommentService;

public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping(value = "/addcomment")
	public String addComment(Comment comment, Model model) {

		comment.setCreatedDate(new Date());
		comment.setUpdatedDate(new Date());
		commentService.addComment(comment);
		model.addAttribute("comment", comment);
		return "redirect:/comments";

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
