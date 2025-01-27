package com.example.backend.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Servico;
import com.example.backend.service.ExcelService;
import com.example.backend.service.GerenciadorDePrecos;

@RestController
@RequestMapping("/api/dono")
public class DonoController {

    private final GerenciadorDePrecos gerenciadorDePrecos;
    private final ExcelService excelService;

    public DonoController(GerenciadorDePrecos gerenciadorDePrecos, ExcelService excelService) {
        this.gerenciadorDePrecos = gerenciadorDePrecos;
        this.excelService = excelService;
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

    @GetMapping("/relatorio-gastos")
    public ResponseEntity<InputStreamResource> baixarRelatorioGastos() {
        try {
            // Exemplo de dados que poderiam vir de um repositório ou serviço
            List<String> dados = Arrays.asList(
                "Banho e Tosa;150.00;2025-01-10",
                "Alimentação;300.00;2025-01-15"
            );

            ByteArrayInputStream relatorio = excelService.gerarRelatorioGastos(dados);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=relatorio-gastos.xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(relatorio));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
