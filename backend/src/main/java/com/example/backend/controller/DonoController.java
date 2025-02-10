package com.example.backend.controller;

import com.example.backend.models.Cliente;
import com.example.backend.models.Dono;
import com.example.backend.models.Servico;
import com.example.backend.service.ClienteService;
import com.example.backend.service.DonoService;
import com.example.backend.service.GerenciadorDePrecos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dono")
public class DonoController {

    @Autowired
    private DonoService donoService;
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
    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<Dono> login(@PathVariable String email, @PathVariable String senha) {
        Dono dono = donoService.autenticarDono(email, senha);
        return ResponseEntity.ok(dono);
    }
}
