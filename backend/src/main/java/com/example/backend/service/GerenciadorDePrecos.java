package com.example.backend.service;

import com.example.backend.models.Servico;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

@Service
public class GerenciadorDePrecos {

    private final Map<Servico, Double> precos = new EnumMap<>(Servico.class);
    private final DonoService donoService;

    public GerenciadorDePrecos(DonoService donoService) {
        this.donoService = donoService;
        precos.put(Servico.BANHO, 30.0);
        precos.put(Servico.TOSA, 50.0);
    }

    public double getPreco(Servico servico) {
        return precos.get(servico);
    }

    public void alterarPreco(Servico servico, double novoPreco, String email, String senha) {
        // Autentica o dono usando DonoService
        donoService.autenticarDono(email, senha);

        if (novoPreco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }

        precos.put(servico, novoPreco);
    }
}
