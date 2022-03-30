package br.com.fiap.jpa.exception;

public class CommitException extends Exception {

	public CommitException() {
		super("Erro ao realizar commit");
	}
	
	public CommitException(String msg) {
		super(msg);
	}
	
	
}
