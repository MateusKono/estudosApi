package br.com.estudoapi.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	private Autor autor;
	
	@JsonProperty
	private String titulo;
	
	@JsonProperty
	private String sinopse;
	
	@OneToMany(mappedBy = "livro", cascade=CascadeType.ALL)
	@JsonInclude(Include.NON_EMPTY)
	private List<Comentario> comentarios;
	
	protected Livro(){}
	
	public Livro(long id, String editora, Autor autor, String titulo, String sinopse, List<Comentario> comentarios){
		this.id = id;
		this.editora = editora;
		this.autor = autor;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.comentarios = comentarios;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setAutor(Autor autor) {
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

	public Autor getAutor() {
		return autor;
	}
	
	public String getTitulo(){
		return titulo;
	}

	public String getSinopse() {
		return sinopse;
	}
}
