package it.panettone.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;


	@Entity
	public class Ingredienti {

		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<Panettone> getPanettone() {
			return panettone;
		}

		public void setPanettone(List<Panettone> panettone) {
			this.panettone = panettone;
		}

		public String getIngredienti() {
			return ingredienti;
		}

		public void setIngredienti(String ingredienti) {
			this.ingredienti = ingredienti;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private Long id;
		
		@NotBlank(message = "Il panettone non è fatto con l'aria: aggiungi almeno un ingrediente")
		private String ingredienti;
		
		@ManyToMany(mappedBy = "ingredienti")
		@JsonBackReference
		private List <Panettone> panettone;
	}

