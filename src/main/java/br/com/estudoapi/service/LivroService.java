package br.com.estudoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudoapi.exception.LivroNaoEncontradoException;
import br.com.estudoapi.pojo.Comentario;
import br.com.estudoapi.pojo.Livro;
import br.com.estudoapi.repository.ComentariosRepository;
import br.com.estudoapi.repository.LivrosRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivrosRepository livroRepository;
	
	@Autowired 
	private ComentariosRepository comentariosRepository;
	
	public List<Livro> listar(){
		return livroRepository.findAll();
	}
	
	public Livro buscar(long id){
		Livro toReturn = livroRepository.findById(id);
		
		if (toReturn == null)
			throw new LivroNaoEncontradoException("Livro não encontrado");
			
		return toReturn;
	}
	
	public Livro salvar(Livro livro){
		return livroRepository.save(livro);
	}
	
	public void deletar(Livro livro){
		livroRepository.delete(livro);
	}
	
	public Comentario salvarComentario(long id, Comentario comentario){
		Livro livro = buscar(id);
		
		comentario.setLivro(livro);
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Livro livro){
		return comentariosRepository.findByLivro(livro);
	}
}
