package br.com.estudoapi.resource;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudoapi.pojo.Livro;

@RestController
public class LivrosResource {
	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public ArrayList<Livro> listar(){
		ArrayList<Livro> list = new ArrayList<Livro>();
		return list;
	}
}
