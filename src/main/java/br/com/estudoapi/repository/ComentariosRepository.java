package br.com.estudoapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudoapi.pojo.Comentario;
import br.com.estudoapi.pojo.Livro;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentario, Long>{
	Comentario findById(long id);
	
	List<Comentario> findByLivro(Livro livro);
}
