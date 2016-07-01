package br.com.estudoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudoapi.exception.AutorExistenteException;
import br.com.estudoapi.exception.AutorNaoEncontradoException;
import br.com.estudoapi.exception.LivroNaoEncontradoException;
import br.com.estudoapi.pojo.Autor;
import br.com.estudoapi.pojo.Livro;
import br.com.estudoapi.repository.AutoresRepository;

@Service
public class AutorService {

	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor){
		if(autoresRepository.findById(autor.getId()) != null)
			throw new AutorExistenteException("Autor já cadastrado");
			
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(long id){
		Autor toReturn = autoresRepository.findById(id);
		
		if (toReturn == null)
			throw new AutorNaoEncontradoException("Autor não encontrado");
			
		return toReturn;
	}
}
