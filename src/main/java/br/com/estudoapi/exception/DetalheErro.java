package br.com.estudoapi.exception;

public class DetalheErro {
	
	private int code;
	
	private String message;
	
	private String detail;

	public DetalheErro(int code, String message, String detail) {
		this.code = code;
		this.message = message;
		this.detail = detail;
	}
}
