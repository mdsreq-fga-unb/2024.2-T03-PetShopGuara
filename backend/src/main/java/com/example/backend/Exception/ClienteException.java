package com.example.backend.Exception;

public class ClienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ClienteException(String mensagem) {
		super(mensagem); //Função para inserir uma mensagem
	}

}