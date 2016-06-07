package br.com.estudoapi.resource;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.estudoapi.pojo.Livro;
import br.com.estudoapi.repository.LivrosRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivrosResource {
	
	@Autowired
	private LivrosRepository livroRepository;
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar(){
		return ResponseEntity.ok(livroRepository.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Livro livro){
		livro = livroRepository.save(livro);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(livro.getId()).toUri();
				
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> buscar(@PathVariable(value = "id") long id){
		if(livroRepository.findById(id) == null)
			return new ResponseEntity<Livro>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Livro>(livroRepository.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remover(@PathVariable(value = "id") long id){
		livroRepository.delete(livroRepository.findById(id));
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable(value = "id") long id){
		livro.setId(id);
		
		livroRepository.save(livro);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").
				buildAndExpand(livro.getId()).toUri();;
				
		return ResponseEntity.created(location).build();
	}
}
