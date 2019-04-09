package Entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rating
 *
 */
@Entity

public class Rating implements Serializable {

	@EmbeddedId
	private RatingId ratingId;
	private Integer score;
	@ManyToOne
	@JoinColumn(name="idUser",referencedColumnName="id",updatable=false,insertable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idContent",referencedColumnName="id",updatable=false,insertable=false)
	private Content content;
	public RatingId getRatingId() {
		return ratingId;
	}
	public void setRatingId(RatingId ratingId) {
		this.ratingId = ratingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}

	private static final long serialVersionUID = 1L;

	public Rating() {
		super();
	}   
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	public Rating(Integer score, User user, Content content) {
		super();
		this.ratingId= new RatingId(user.getId(), user.getId());
		this.score = score;
		this.user = user;
		this.content = content;
	}
   
}
