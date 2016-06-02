package br.com.estudoapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosResource {
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public String listar(){
		return "listar";
	}
}
