package ea.project.finalProject.restcontroller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ea.project.finalProject.model.Comment;
import ea.project.finalProject.service.CommentService;

@RequestMapping(value="/rest/")
public class CommentControllerRest {
	
	@Autowired
	private CommentService commentService;

	@PostMapping(value = "/addcomment")
	public Comment addComment(Comment comment, Model model) {

		comment.setCreatedDate(new Date());
		comment.setUpdatedDate(new Date());
		commentService.addComment(comment);

		return comment;

	}

	@PostMapping(value = "/deletecomment")
	public boolean deleteComment(Comment comment, Model model) {
		commentService.deleteComment(comment);
		return "redirect:/comments";

	}

	@PostMapping(value = "/updatecomment")
	public String updateComment(Comment comment, Model model) {
		comment.setUpdatedDate(new Date());
		commentService.updateComment(comment);
		return "redirect:/comments";

	}
	

}
