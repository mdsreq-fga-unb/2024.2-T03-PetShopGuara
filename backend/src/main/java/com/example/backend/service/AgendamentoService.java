package com.example.backend.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.backend.Exception.AgendamentoException;
import com.example.backend.dto.AgendamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Agendamento;
import com.example.backend.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Agendar banho e tosa
    public Agendamento agendarBanhoTosa(Agendamento agendamento) {
        return agendamentoRepository.saveAndFlush(agendamento);
    }

    // Cancelar agendamento
    public boolean cancelarAgendamento(Long id) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if (agendamento.isPresent()) {
            agendamentoRepository.delete(agendamento.get());
            return true;
        }
        return false;
    }

    public List<LocalDateTime> obterHorariosDisponiveis(LocalDateTime inicioDoDia, int duracao) {
    List<LocalDateTime> horariosDisponiveis = new ArrayList<>();
    LocalDateTime horarioAtual = inicioDoDia.withHour(8); // Início do expediente às 8h
    LocalDateTime horarioFinal = inicioDoDia.withHour(18); // Fim do expediente às 18h

    while (horarioAtual.isBefore(horarioFinal)) {
        horariosDisponiveis.add(horarioAtual);
        horarioAtual = horarioAtual.plusMinutes(30); // Intervalos de 30 minutos
    }

    // Filtrar horários já ocupados
    List<Agendamento> horariosOcupados = agendamentoRepository.findByDataHoraBetween(inicioDoDia, inicioDoDia.plusDays(1));
    horariosDisponiveis.removeAll(horariosOcupados);

    return horariosDisponiveis;
    }
   // Buscar agendamentos por data específica
    public List<Agendamento> buscarAgendamentosPorData(LocalDateTime inicio, LocalDateTime fim) {
        return agendamentoRepository.findByDataHoraBetween(inicio, fim);
}

// Buscar todos os agendamentos
    public List<AgendamentoDTO> buscarTodosAgendamentos() {
        List<Agendamento> agendamentoExist = agendamentoRepository.findAll();
        List<AgendamentoDTO> agendamentoDTOs = new ArrayList<>();
        if (!agendamentoExist.isEmpty()) {
            for (Agendamento agendamento : agendamentoExist) {
                AgendamentoDTO agendamentoDto = new AgendamentoDTO(); // cria uma instância do agendamentoDTO
                agendamentoDto.setId(agendamento.getId());
                agendamentoDto.setPet(agendamento.getPet());
                agendamentoDto.setCliente(agendamento.getCliente());
                agendamentoDto.setDataHora(agendamento.getDataHora());
                agendamentoDto.setServico(agendamento.getServico());
                agendamentoDto.setValor(agendamento.getValor());
                // Outros atributos do AgendamentoDTO que você precise setar
                agendamentoDTOs.add(agendamentoDto);
            }// verifica se existe o agendamento
            return agendamentoDTOs;
        } else {
            throw new AgendamentoException("agendamento não existe!"); // mensagem de erro
        }

}}
    

