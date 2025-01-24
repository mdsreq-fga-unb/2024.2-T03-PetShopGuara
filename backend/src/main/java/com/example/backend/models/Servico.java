package com.example.backend.models;

public enum Servico {

    BANHO("Banho"),
    TOSA("Tosa");

    private final String nome;

    Servico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
