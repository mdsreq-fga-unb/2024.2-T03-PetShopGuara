package com.example.backend.controller;

import com.example.backend.dto.HorarioFuncionamentoDTO;
import com.example.backend.models.Agendamento;
import com.example.backend.models.Servico;
import com.example.backend.service.DonoService;
import com.example.backend.service.ExcelService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dono")
public class DonoController {

    private final DonoService donoService;
    private final ExcelService excelService;

    public DonoController(DonoService donoService, ExcelService excelService) {
        this.donoService = donoService;
        this.excelService = excelService;
    }

    @PostMapping("/alterar-preco")
    public String alterarPrecoServico(
            @RequestParam String nomeServico,
            @RequestParam double novoPreco,
            @RequestParam String email,
            @RequestParam String senha) {

        Servico servico = Servico.valueOf(nomeServico.toUpperCase());
        // Lógica para alterar preço (implemente conforme necessário)
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
            // Obter o mês atual e o mês anterior
            LocalDate hoje = LocalDate.now();
            int mesAtual = hoje.getMonthValue();
            int anoAtual = hoje.getYear();

            // Obter atendimentos de Banho e Tosa do mês atual
            List<Agendamento> atendimentosBanhoTosa = donoService.getAtendimentosBanhoTosaDoMes(mesAtual, anoAtual);

            // Calcular total de Banho e Tosa
            double totalBanhoTosa = atendimentosBanhoTosa.stream()
                    .mapToDouble(Agendamento::getValor)
                    .sum();

            // Obter despesas totais do mês atual
            double totalDespesasMesAtual = donoService.getDespesasDoMes(mesAtual, anoAtual);

            // Calcular lucro do mês atual
            double lucroMesAtual = totalBanhoTosa - totalDespesasMesAtual;

            // Preparar dados para o relatório
            List<String> dados = new ArrayList<>();

            // Adicionar atendimentos individuais de Banho e Tosa
            for (Agendamento atendimento : atendimentosBanhoTosa) {
                dados.add("Banho e Tosa;" + atendimento.getValor() + ";" + atendimento.getDataHora().toLocalDate());
            }

            // Adicionar total de Banho e Tosa
            dados.add("Total Banho e Tosa;" + totalBanhoTosa + ";");

            // Adicionar receita total e lucro
            dados.add("Receita Total;" + totalBanhoTosa + ";");
            dados.add("Lucro Mês Atual;" + lucroMesAtual + ";");

            // Gerar relatório
            ByteArrayInputStream relatorio = excelService.gerarRelatorioGastos(dados);

            // Cabeçalho para download
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