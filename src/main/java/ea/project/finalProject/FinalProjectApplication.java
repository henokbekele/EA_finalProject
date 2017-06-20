package ea.project.finalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import antlr.CSharpCodeGenerator;
import ea.project.finalProject.service.CommentService;

@SpringBootApplication
public class FinalProjectApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
		
		// CommentService cs= new  CommentService();
		// System.out.println("number of comment for post 1:"+cs.getCommentForPost(1).size());
		
	}
}
