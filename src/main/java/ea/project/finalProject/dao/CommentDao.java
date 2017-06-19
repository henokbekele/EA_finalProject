package ea.project.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ea.project.finalProject.model.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer>{

}
