package br.com.estudoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AutorNaoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String strError;

	public AutorNaoEncontradoException(final String strError){
		this.strError = strError;
	}
}
