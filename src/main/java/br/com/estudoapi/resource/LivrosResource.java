package br.com.estudoapi.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudoapi.pojo.Livro;
import br.com.estudoapi.repository.LivrosRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivrosResource {
	
	@Autowired
	private LivrosRepository livroRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar(){
		return livroRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Livro livro){
		livroRepository.save(livro);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Livro buscar(@PathVariable(value = "id") long id){
		return livroRepository.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void remover(@PathVariable(value = "id") long id){
		Livro livro = livroRepository.findById(id);
		livroRepository.delete(livro);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Livro livro, @PathVariable(value = "id") long id){
		livro.setId(id);
		livroRepository.save(livro);
	}
}
