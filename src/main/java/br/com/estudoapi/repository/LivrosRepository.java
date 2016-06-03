package br.com.estudoapi.repository;

import org.springframework.stereotype.Repository;

import br.com.estudoapi.pojo.Livro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LivrosRepository extends JpaRepository<Livro, Long>{
	
	Livro findById(long id);
	
	List<Livro> findByEditora(String editora);
	
	List<Livro> findByAutor(String autor);
	
	List<Livro> findByTitulo(String titulo);
	
	List<Livro> findBySinopse(String sinopse);
}
