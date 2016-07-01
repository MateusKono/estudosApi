package br.com.estudoapi.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIVRO_ID")
	@NotNull(message = "Campo obrigatório.")
	@JsonIgnore
	private Livro livro;
	
	@Size(max = 1500, message = "O campo texto excedeu o tamanho permitido. Permitido 1500 caracteres.")
	@JsonProperty(value = "comentario")
	@NotNull(message = "Campo obrigatório.")
	private String texto;
	
	protected Comentario(){}
	
	public Comentario(long id, Livro livro, String texto){
		this.id = id;
		this.livro = livro;
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
