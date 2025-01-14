package com.example.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.backend.models.Dono;
import com.example.backend.models.Pet;
import com.example.backend.models.Agendamento;
import com.example.backend.repository.DonoRepository;
import com.example.backend.repository.PetRepository;
import com.example.backend.service.AgendamentoService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;
    
    @Autowired
    private PetRepository petRepository;
    
    @Autowired
    private DonoRepository donoRepository;
    // Endpoint para agendar banho e tosa
    @PostMapping("/agendar")
    public Agendamento agendar(@RequestParam Long petId, @RequestParam Long donoId, @RequestParam String dataHora) {
        // Aqui você vai buscar o pet e dono no banco e fazer o agendamento
        Pet pet = petRepository.findById(petId).orElse(null);  // Exemplo de busca
        Dono dono = donoRepository.findById(donoId).orElse(null); // Exemplo de busca
        LocalDateTime data = LocalDateTime.parse(dataHora); // Supondo que a data está no formato ISO-8601
        
        return agendamentoService.agendarBanhoTosa(pet, dono, data);
    }

    // Endpoint para cancelar agendamento
    @DeleteMapping("/cancelar/{id}")
    public boolean cancelar(@PathVariable Long id) {
        return agendamentoService.cancelarAgendamento(id);
    }
}
