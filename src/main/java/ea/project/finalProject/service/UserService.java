package ea.project.finalProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ea.project.finalProject.dao.UserDao;
import ea.project.finalProject.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public User getUser(Integer id) {
		return userDao.findOne(id);

	}

	public User addUser(User user) {
		return userDao.save(user);
	}

	public User updateUser(User user) {
		return userDao.save(user);
	}

	public void deleteUser(int id) {
		userDao.delete(id);
	}

	public void deleteAllUsers() {
		userDao.deleteAll();
	}

	public User findByEmail(String email) {
		return userDao.findByAddress_EmailIgnoreCase(email);
	}

	public User findByUsername(String username) {
		return userDao.findByUsernameIgnoreCase(username);
	}

	public boolean usernameExists(String username) {
		return findByUsername(username) != null;
	}

	public boolean emailExists(String email) {
		return findByEmail(email) != null;
	}

	public void changeEmail(String email, String currentPassword) {
		// TODO Auto-generated method stub
		
	}

	public User currentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeProfileInfo(User user) {
		// TODO Auto-generated method stub
		
	}

	public User validateUser(User login) {
		// TODO Auto-generated method stub
		return null;
	}
}
