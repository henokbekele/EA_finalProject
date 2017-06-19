package ea.project.finalProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import ea.project.finalProject.dao.CommentDao;
import ea.project.finalProject.model.Comment;
import ea.project.finalProject.model.User;

public class CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	
	public Comment addComment(Comment comment)
	{
		return commentDao.save(comment);
	}
	
	public Comment getComment(int id)
	{
		return commentDao.findOne(id);
	}

	public void deleteComment(Comment comment)
	{
		commentDao.delete(comment);
	}
	
	public int numberOfLikes(int id)
	{
		return commentDao.findOne(id).getLikes().size();
	}
	
	public Comment updateComment(Comment comment)
	{
		return commentDao.save(comment);
	}
	
	public boolean statusLikeComment(User user, Comment comment)
	{
		return comment.getLikes().contains(user);
	}

	public Comment likeComment(User user, Comment comment)
	{
		comment.getLikes().add(user);
		return commentDao.save(comment);
	}

	
	public Comment unLikeComment(User user, Comment comment)
	{
		comment.getLikes().remove(user);
		return commentDao.save(comment);
	}
	
}
