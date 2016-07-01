package br.com.estudoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudoapi.pojo.Autor;
import br.com.estudoapi.pojo.Comentario;


@Repository
public interface AutoresRepository extends JpaRepository<Autor, Long>{
	Autor findById(long id);
}
