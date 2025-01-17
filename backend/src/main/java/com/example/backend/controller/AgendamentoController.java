package com.example.backend.controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Agendamento;
import com.example.backend.models.Cliente;
import com.example.backend.models.Pet;
import com.example.backend.repository.ClienteRepository;
import com.example.backend.repository.PetRepository;
import com.example.backend.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;
    
    @Autowired
    private PetRepository petRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    // Endpoint para agendar banho e tosa
    @PostMapping("/agendar")
    public Agendamento agendar(@RequestParam Long petId, @RequestParam Long donoId, @RequestParam String dataHora) {
        // Aqui você vai buscar o pet e dono no banco e fazer o agendamento
        Pet pet = petRepository.findById(petId).orElse(null);  // Exemplo de busca
        Cliente dono = clienteRepository.findById(donoId).orElse(null); // Exemplo de busca
        LocalDateTime data = LocalDateTime.parse(dataHora); // Supondo que a data está no formato ISO-8601
        
        return agendamentoService.agendarBanhoTosa(pet, dono, data);
    }

    // Endpoint para cancelar agendamento
    @DeleteMapping("/cancelar/{id}")
    public boolean cancelar(@PathVariable Long id) {
        return agendamentoService.cancelarAgendamento(id);
    }

    @GetMapping("/horarios-disponiveis")
    public List<LocalDateTime> obterHorariosDisponiveis(
            @RequestParam String data, 
            @RequestParam int duracao) {
    
        LocalDate dataFormatada = LocalDate.parse(data); // Converter data para LocalDate
        return agendamentoService.obterHorariosDisponiveis(dataFormatada.atStartOfDay(), duracao);
    }


@GetMapping("/calendario")
public ResponseEntity<List<Agendamento>> visualizarCalendario(
        @RequestParam(required = false) String dataAgendamento) {

    if (dataAgendamento != null && !dataAgendamento.isEmpty()) {
        // Converter a data fornecida para LocalDate
        LocalDate data = LocalDate.parse(dataAgendamento);
        LocalDateTime inicio = data.atStartOfDay();
        LocalDateTime fim = data.atTime(LocalTime.MAX);

        // Buscar os agendamentos naquela data
        List<Agendamento> agendamentos = agendamentoService.buscarAgendamentosPorData(inicio, fim);
        return ResponseEntity.ok(agendamentos);
    }

    // Caso nenhuma data seja fornecida, retornar todos os agendamentos
    List<Agendamento> agendamentos = agendamentoService.buscarTodosAgendamentos();
    return ResponseEntity.ok(agendamentos);
}


    
}
