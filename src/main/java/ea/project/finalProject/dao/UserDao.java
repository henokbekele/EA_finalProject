package ea.project.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ea.project.finalProject.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByUsernameIgnoreCase(String username);

	User findByFirstnameIgnoreCase(String username);
	
	User findByLastnameIgnoreCase(String username);
	
    User findByAddress_EmailIgnoreCase(String email);

    User findByUsernameOrAddress_Email(String username, String email);
}
