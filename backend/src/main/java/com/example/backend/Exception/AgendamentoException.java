package com.example.backend.Exception;

public class AgendamentoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AgendamentoException(String mensagem) {
        super(mensagem); //Função para inserir uma mensagem
    }
}