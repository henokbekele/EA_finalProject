package ea.project.finalProject.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ea.project.finalProject.model.Comment;
import ea.project.finalProject.service.CommentService;

@RestController
@RequestMapping(value="/rest/")
public class CommentControllerRest {
	
	@Autowired
	private CommentService commentService;

	@GetMapping(value = "/comment/{postId}")
	public List<Comment> getCommentForPost(@PathVariable int postId) {

			return commentService.getCommentForPost(postId);

		//return comment;

	}
	
	@PostMapping(value = "/addcomment")
	public Comment addComment(@RequestBody Comment comment) {

		comment.setCreatedDate(new Date());
		comment.setUpdatedDate(new Date());
		commentService.addComment(comment);

		return comment;

	}

	@DeleteMapping(value = "/deletecomment/{id}")
	public void deleteComment(@PathVariable int id) {
		commentService.deleteCommentById(id);

	}

	@PutMapping(value = "/updatecomment")
	public Comment updateComment(@RequestBody Comment comment) {
		comment.setUpdatedDate(new Date());
		commentService.updateComment(comment);
		return comment;

	}
	

}
