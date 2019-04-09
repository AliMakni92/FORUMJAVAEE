package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {

	@EmbeddedId
	private CommentId commentId;
	private Integer flags;
	private String text;
	private Date date;
	@ManyToOne
	@JoinColumn(name="idUser", referencedColumnName="id",updatable=false, insertable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idContent", referencedColumnName="id",updatable=false, insertable=false)
	private Content content;
	private static final long serialVersionUID = 1L;

	public CommentId getCommentId() {
		return commentId;
	}
	public void setCommentId(CommentId commentId) {
		this.commentId = commentId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment() {
		super();
	}   
	public Integer getFlags() {
		return this.flags;
	}

	public void setFlags(Integer flags) {
		this.flags = flags;
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public Comment(Integer flags, String text, Date date) {
		super();
		this.commentId= new CommentId(user.getId(), content.getId());
		this.flags = flags;
		this.text = text;
		this.date = date;
	}
   
}
