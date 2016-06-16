package br.com.estudoapi.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonInclude(Include.NON_NULL)	
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@JsonProperty
	private long id;
	
	@JsonProperty
	private String editora;
	
	@JsonProperty
	private String autor;
	
	@JsonProperty
	private String titulo;
	
	@JsonProperty
	private String sinopse;
	
	protected Livro(){}
	
	public Livro(long id, String editora, String autor, String titulo, String sinopse){
		this.id = id;
		this.editora = editora;
		this.autor = autor;
		this.titulo = titulo;
		this.sinopse = sinopse;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public long getId() {
		return id;
	}

	public String getEditora() {
		return editora;
	}

	public String getAutor() {
		return autor;
	}
	
	public String getTitulo(){
		return titulo;
	}

	public String getSinopse() {
		return sinopse;
	}
}
