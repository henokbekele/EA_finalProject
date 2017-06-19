package ea.project.finalProject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Post {
	@Id @GeneratedValue
	private int id;
	private String title;
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	private String content;

	@ManyToOne(cascade=CascadeType.ALL)
	private User owner;
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	private List<Comment> comments;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<User> likes ;

	public Post(){}

	public Post(String title, Date createdDate, Date updatedDate, String content, User owner, List<Comment> comments,
			List<User> likes) {
		super();
		this.title = title;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.content = content;
		this.owner = owner;
		this.comments = comments;
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

/*	public void setId(int id) {
		this.id = id;
	}*/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<User> getLikes() {
		return likes;
	}

	public void setLikes(List<User> likes) {
		this.likes = likes;
	}
	
	
}