package com.example.backend.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Agendamento;
import com.example.backend.models.Cliente;
import com.example.backend.models.Pet;
import com.example.backend.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Agendar banho e tosa
    public Agendamento agendarBanhoTosa(Pet pet, Cliente cliente, LocalDateTime dataHora) {
        Agendamento agendamento = new Agendamento();
        agendamento.setDataHora(dataHora);
        agendamento.setCliente(cliente);
        agendamento.setPet(pet);
        
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
    return agendamentoRepository.findByDataBetween(inicio, fim);
}

// Buscar todos os agendamentos
    public List<Agendamento> buscarTodosAgendamentos() {
    return agendamentoRepository.findAll();
    }

}
    

