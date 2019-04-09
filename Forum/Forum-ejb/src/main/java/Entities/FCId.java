package Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class FCId implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer idFavorites;
private Integer idContent;
public Integer getIdFavorites() {
	return idFavorites;
}
public void setIdFavorites(Integer idFavorites) {
	this.idFavorites = idFavorites;
}
public Integer getIdContent() {
	return idContent;
}
public void setIdContent(Integer idContent) {
	this.idContent = idContent;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((idContent == null) ? 0 : idContent.hashCode());
	result = prime * result + ((idFavorites == null) ? 0 : idFavorites.hashCode());
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
	FCId other = (FCId) obj;
	if (idContent == null) {
		if (other.idContent != null)
			return false;
	} else if (!idContent.equals(other.idContent))
		return false;
	if (idFavorites == null) {
		if (other.idFavorites != null)
			return false;
	} else if (!idFavorites.equals(other.idFavorites))
		return false;
	return true;
}
public FCId() {
	super();
	// TODO Auto-generated constructor stub
}
public FCId(Integer idFavorites, Integer idContent) {
	super();
	this.idFavorites = idFavorites;
	this.idContent = idContent;
}

}
