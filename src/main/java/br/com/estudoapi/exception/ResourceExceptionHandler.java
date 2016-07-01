package br.com.estudoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<DetalheErro> trataLivroNaoEncontrado(LivroNaoEncontradoException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetalheErro(
				HttpStatus.NOT_FOUND.value(), ex.getMessage(), "https://www.google.com.br/"));
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<DetalheErro> trataAutorNaoEncontrado(AutorNaoEncontradoException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetalheErro(
				HttpStatus.NOT_FOUND.value(), ex.getMessage(), "https://www.google.com.br/"));
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ResponseEntity<DetalheErro> trataAutorNaoEncontrado(AutorExistenteException ex){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new DetalheErro(
				HttpStatus.CONFLICT.value(), ex.getMessage(), "https://www.google.com.br/"));
	}
}
