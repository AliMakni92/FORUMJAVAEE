package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Award
 *
 */
@Entity

public class Award implements Serializable {

	@EmbeddedId
	private AwardId awardId;
	private String name;
	private String field;
	private String value;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="idContent",referencedColumnName="id",updatable=false,insertable=false)
	private Content content;
	
	@ManyToOne
	@JoinColumn(name="idCast",referencedColumnName="id",updatable=false,insertable=false)
	private Cast cast;
	
	
	private static final long serialVersionUID = 1L;

	public AwardId getAwardId() {
		return awardId;
	}
	public void setAwardId(AwardId awardId) {
		this.awardId = awardId;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public Cast getCast() {
		return cast;
	}
	public void setCast(Cast cast) {
		this.cast = cast;
	}
	public Award() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}   
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}   
	
	   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Award(String name, String field, String value, String description, Content content, Cast cast) {
		super();
		this.awardId= new AwardId(content.getId(), cast.getId());
		this.name = name;
		this.field = field;
		this.value = value;
	
		this.description = description;
		this.content = content;
		this.cast = cast;
	}
   
}
