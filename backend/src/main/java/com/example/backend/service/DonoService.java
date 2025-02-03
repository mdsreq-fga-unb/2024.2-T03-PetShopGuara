package com.example.backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.Exception.AutenticacaoDonoException;
import com.example.backend.dto.HorarioFuncionamentoDTO;
import com.example.backend.models.Agendamento;
import com.example.backend.models.Dono;
import com.example.backend.repository.AgendamentoRepository;
import com.example.backend.repository.DonoRepository;

@Service
public class DonoService {

    private final DonoRepository donoRepository;
    private final AgendamentoRepository agendamentoRepository;

    public DonoService(DonoRepository donoRepository, AgendamentoRepository agendamentoRepository) {
        this.donoRepository = donoRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    // Métodos existentes (mantidos inalterados)
    public Dono autenticarDono(String email, String senha) {
        Dono dono = donoRepository.findByEmail(email)
                .orElseThrow(() -> new AutenticacaoDonoException("Email inválido."));

        if (!dono.getSenha().equals(senha)) {
            throw new AutenticacaoDonoException("Senha incorreta.");
        }

        return dono;
    }

    public void alterarHorarioFuncionamento(HorarioFuncionamentoDTO horarioDTO) {
        Dono dono = donoRepository.findById(1L)  // Supondo que há apenas um dono no sistema
                .orElseThrow(() -> new RuntimeException("Dono não encontrado!"));

        dono.setAbertura(horarioDTO.getAbertura());
        dono.setFechamento(horarioDTO.getFechamento());

        donoRepository.save(dono);
    }

    // Novos métodos adicionados
    public List<Agendamento> getAtendimentosBanhoTosaDoMes(int mes, int ano) {
        // Define o intervalo de datas para o mês e ano especificados
        LocalDateTime start = LocalDate.of(ano, mes, 1).atStartOfDay();
        LocalDateTime end = LocalDate.of(ano, mes, 1).plusMonths(1).atStartOfDay();

        // Busca agendamentos de Banho e Tosa no intervalo de datas
        return agendamentoRepository.findByDataHoraBetween(start, end);
    }

    public double getDespesasDoMes(int mes, int ano) {
        // Define o intervalo de datas para o mês e ano especificados
        LocalDateTime start = LocalDate.of(ano, mes, 1).atStartOfDay();
        LocalDateTime end = LocalDate.of(ano, mes, 1).plusMonths(1).atStartOfDay();

        // Busca todos os agendamentos no intervalo de datas
        List<Agendamento> agendamentos = agendamentoRepository.findByDataHoraBetween(start, end);

        // Calcula o total de despesas (supondo que o valor do serviço é a despesa)
        return agendamentos.stream()
                .mapToDouble(Agendamento::getValor)
                .sum();
    }
}