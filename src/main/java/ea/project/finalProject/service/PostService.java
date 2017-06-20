package ea.project.finalProject.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ea.project.finalProject.dao.PostDao;
import ea.project.finalProject.model.Post;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	public void addPost(Post post){
		this.postDao.save(post);
	}
	
	public Collection<Post> getAllPost(){
		return this.postDao.findAll();
	}
	
	public Post getPost(int postId){
		return this.postDao.findOne(postId);
	}
	
	public void deletePost(Post post){
		this.postDao.delete(post);
	}
	
	public void removePostById(int  postId){
		this.postDao.delete(postId);
	}

}
