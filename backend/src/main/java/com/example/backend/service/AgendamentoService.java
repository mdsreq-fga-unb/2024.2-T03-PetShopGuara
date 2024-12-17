package com.example.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Dono;
import com.example.backend.models.Pet;
import com.example.backend.models.agendamento;
import com.example.backend.repository.AgendamentoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Agendar banho e tosa
    public agendamento agendarBanhoTosa(Pet pet, Dono dono, LocalDateTime dataHora) {
        agendamento agendamento = new agendamento(pet, dono, dataHora);
        return agendamentoRepository.save(agendamento);
    }

    // Cancelar agendamento
    public boolean cancelarAgendamento(Long id) {
        Optional<agendamento> agendamento = agendamentoRepository.findById(id);
        if (agendamento.isPresent()) {
            agendamentoRepository.delete(agendamento.get());
            return true;
        }
        return false;
    }
}
