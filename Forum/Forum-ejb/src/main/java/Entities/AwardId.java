package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class AwardId implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer idContent;
private Integer idCast;
private Date date;



public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Integer getIdContent() {
	return idContent;
}
public void setIdContent(Integer idContent) {
	this.idContent = idContent;
}
public Integer getIdCast() {
	return idCast;
}
public void setIdCast(Integer idCast) {
	this.idCast = idCast;
}
public AwardId(Integer idContent, Integer idCast) {
	super();
	this.idContent = idContent;
	this.idCast = idCast;
	this.date = new Date();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((idCast == null) ? 0 : idCast.hashCode());
	result = prime * result + ((idContent == null) ? 0 : idContent.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AwardId other = (AwardId) obj;
	if (idCast == null) {
		if (other.idCast != null)
			return false;
	} else if (!idCast.equals(other.idCast))
		return false;
	if (idContent == null) {
		if (other.idContent != null)
			return false;
	} else if (!idContent.equals(other.idContent))
		return false;
	return true;
}

public AwardId() {
	super();
	// TODO Auto-generated constructor stub
}



}
