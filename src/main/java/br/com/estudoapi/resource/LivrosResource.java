package br.com.estudoapi.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
