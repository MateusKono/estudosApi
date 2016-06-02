package br.com.estudoapi.pojo;

public class Livro {
	
	private long id;
	
	private String editora;
	
	private String autor;
	
	private String titulo;
	
	private String sinopse;
	
	
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
