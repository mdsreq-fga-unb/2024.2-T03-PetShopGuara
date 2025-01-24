package com.example.backend.controller;

import com.example.backend.models.Servico;
import com.example.backend.service.GerenciadorDePrecos;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dono")
public class DonoController {

    private final GerenciadorDePrecos gerenciadorDePrecos;

    public DonoController(GerenciadorDePrecos gerenciadorDePrecos) {
        this.gerenciadorDePrecos = gerenciadorDePrecos;
    }

    @PostMapping("/alterar-preco")
    public String alterarPrecoServico(
            @RequestParam String nomeServico,
            @RequestParam double novoPreco,
            @RequestParam String email,
            @RequestParam String senha) {

        Servico servico = Servico.valueOf(nomeServico.toUpperCase());
        gerenciadorDePrecos.alterarPreco(servico, novoPreco, email, senha);
        return "Preço atualizado para " + servico.getNome() + ": R$ " + novoPreco;
    }
}
