package it.panettone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import it.panettone.controller.PanettoneController;
import it.panettone.model.*;

@Entity
@Table(name = "panettoni")

public class Panettone {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;

    private String foto;

    @NotNull(message = "Il prezzo non può essere nullo")
    @Min(value = 1, message = "Il prezzo deve essere maggiore di 0")
    private Integer prezzo;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "panettoni_ingredienti",
    		joinColumns = @JoinColumn(name = "panettone_id"),
    		inverseJoinColumns = @JoinColumn(name = "ingredienti_id")
    		)
	private List<Ingredienti> ingredienti;
    
	public List<Ingredienti> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingredienti> ingredienti) {
		this.ingredienti = ingredienti;
	}

	
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}


}
