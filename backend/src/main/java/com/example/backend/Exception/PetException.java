package com.example.backend.Exception;

public class PetException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PetException(String mensagem) {
		super(mensagem); //Função para inserir uma mensagem
	}

}