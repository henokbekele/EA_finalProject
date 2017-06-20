package ea.project.finalProject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	private Date dob;
	private String sex;
	private String username;
	private String password;
	
	@Embedded
	private Address address;
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Post> posts;
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Comment> comments;
	@ManyToMany(mappedBy="likes", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Post> likedPosts;
	
	@ManyToMany(mappedBy="likes")
	@JsonIgnore
	private List<Comment> likedComments;
	
	@ManyToMany
	private List<User> friends;
	
	public User(){}
	

	public User(String firstname, String lastname, Date dob, String sex, String username, String password,
			Address address, List<Post> posts, List<Comment> comments, List<Post> likedPosts,
			List<Comment> likedComments) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.sex = sex;
		this.username = username;
		this.password = password;
		this.address = address;
		this.posts = posts;
		this.comments = comments;
		this.likedPosts = likedPosts;
		this.likedComments = likedComments;
	}



	public int getId() {
		return id;
	}

/*	public void setId(int id) {
		this.id = id;
	}*/

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Post> getLikedPosts() {
		return likedPosts;
	}

	public void setLikedPosts(List<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}

	public List<Comment> getLikedComments() {
		return likedComments;
	}

	public void setLikedComments(List<Comment> likedComments) {
		this.likedComments = likedComments;
	}
	
	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	

}
			