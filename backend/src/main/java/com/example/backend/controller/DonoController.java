package com.example.backend.controller;

import com.example.backend.dto.HorarioFuncionamentoDTO;
import com.example.backend.models.Servico;
import com.example.backend.service.ExcelService;
import com.example.backend.service.GerenciadorDePrecos;
import com.example.backend.service.DonoService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/dono")
public class DonoController {

    private final GerenciadorDePrecos gerenciadorDePrecos;
    private final ExcelService excelService;
    private final DonoService donoService;

    public DonoController(GerenciadorDePrecos gerenciadorDePrecos, ExcelService excelService, DonoService donoService) {
        this.gerenciadorDePrecos = gerenciadorDePrecos;
        this.excelService = excelService;
        this.donoService = donoService;
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

    @PostMapping("/alterar-horario")
    public String alterarHorarioFuncionamento(
            @RequestBody HorarioFuncionamentoDTO horarioDTO,
            @RequestParam String email,
            @RequestParam String senha) {

        donoService.autenticarDono(email, senha);
        donoService.alterarHorarioFuncionamento(horarioDTO);
        
        return "Horário de funcionamento atualizado com sucesso!";
    }

    @GetMapping("/relatorio-gastos")
    public ResponseEntity<InputStreamResource> baixarRelatorioGastos() {
        try {
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
