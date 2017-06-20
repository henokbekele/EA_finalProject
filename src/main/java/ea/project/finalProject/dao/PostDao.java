package ea.project.finalProject.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ea.project.finalProject.model.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Integer>{
	
}
