package com.example.backend.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.backend.models.Agendamento;
import com.example.backend.models.Cliente;
import com.example.backend.models.Pet;
import com.example.backend.repository.AgendamentoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Agendar banho e tosa
    public Agendamento agendarBanhoTosa(Pet pet, Cliente dono, LocalDateTime dataHora) {
        Agendamento agendamento = new Agendamento();
        agendamento.setDataHora(dataHora);
        agendamento.setDono(dono);
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
}
