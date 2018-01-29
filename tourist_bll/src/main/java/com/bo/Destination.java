package com.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Destination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Long id;
	   private String nomDest;
	   private String pays;
	   private String ville;
	   private String description;
	   private String image;
	   private double note;
	    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "destination_id")
	   private List<Commentaire> commentaires;

		@Override
		public String toString() {
			return "Destination [id=" + id + ", nomDest=" + nomDest + ", pays=" + pays + ", ville=" + ville
					+ ", description=" + description + ", image=" + image + ", commentaires=" + commentaires + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNomDest() {
			return nomDest;
		}

		public void setNomDest(String nomDest) {
			this.nomDest = nomDest;
		}

		public String getPays() {
			return pays;
		}

		public void setPays(String pays) {
			this.pays = pays;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public List<Commentaire> getCommentaires() {
			return commentaires;
		}

		public void setCommentaires(List<Commentaire> commentaires) {
			this.commentaires = commentaires;
		}

		public double getNote() {
			return note;
		}

		public void setNote(double note) {
			this.note = note;
		}
	   
		public void addCommentaire(Commentaire c) {

			commentaires.add(c);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((nomDest == null) ? 0 : nomDest.hashCode());
			long temp;
			temp = Double.doubleToLongBits(note);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((pays == null) ? 0 : pays.hashCode());
			result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
			Destination other = (Destination) obj;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (nomDest == null) {
				if (other.nomDest != null)
					return false;
			} else if (!nomDest.equals(other.nomDest))
				return false;
			if (Double.doubleToLongBits(note) != Double.doubleToLongBits(other.note))
				return false;
			if (pays == null) {
				if (other.pays != null)
					return false;
			} else if (!pays.equals(other.pays))
				return false;
			if (ville == null) {
				if (other.ville != null)
					return false;
			} else if (!ville.equals(other.ville))
				return false;
			return true;
		}
	    
		

}