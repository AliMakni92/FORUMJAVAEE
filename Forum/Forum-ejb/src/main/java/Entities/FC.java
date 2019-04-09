package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FC
 *
 */
@Entity

public class FC implements Serializable {

	@EmbeddedId
	private FCId fcId;
	@ManyToOne
	@JoinColumn(name="idContent",referencedColumnName="id",updatable=false,insertable=false)
	private Content content;
	@ManyToOne
	@JoinColumn(name="idFavorites",referencedColumnName="id",updatable=false,insertable=false)
	private Favorites favorites;
	private static final long serialVersionUID = 1L;

	public FC() {
		super();
	}

	public FCId getFcId() {
		return fcId;
	}

	public void setFcId(FCId fcId) {
		this.fcId = fcId;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Favorites getFavorites() {
		return favorites;
	}

	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
	}
   
}
