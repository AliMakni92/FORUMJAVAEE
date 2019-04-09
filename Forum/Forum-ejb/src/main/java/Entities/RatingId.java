package Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RatingId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idUser;
	private Integer idContent;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdContent() {
		return idContent;
	}

	public void setIdContent(Integer idContent) {
		this.idContent = idContent;
	}

	public RatingId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingId(Integer idUser, Integer idContent) {
		super();
		this.idUser = idUser;
		this.idContent = idContent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idContent == null) ? 0 : idContent.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
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
		RatingId other = (RatingId) obj;
		if (idContent == null) {
			if (other.idContent != null)
				return false;
		} else if (!idContent.equals(other.idContent))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

}
