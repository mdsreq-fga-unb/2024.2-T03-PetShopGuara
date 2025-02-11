package com.example.backend.controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.example.backend.dto.AgendamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.models.Agendamento;
import com.example.backend.repository.ClienteRepository;
import com.example.backend.repository.PetRepository;
import com.example.backend.service.AgendamentoService;

@CrossOrigin(origins = {"https://two024-2-t03-petshopguara-tlv0.onrender.com", "http://127.0.0.1:5501"})
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
    public Agendamento agendar(@RequestBody Agendamento agendamento) {
        return agendamentoService.agendarBanhoTosa(agendamento);
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


//    @GetMapping("/calendario")
//    public ResponseEntity<List<Agendamento>> visualizarCalendario(
//        @RequestParam(required = false) String dataAgendamento) {
//
//        if (dataAgendamento != null && !dataAgendamento.isEmpty()) {
//        // Converter a data fornecida para LocalDate
//        LocalDate data = LocalDate.parse(dataAgendamento);
//        LocalDateTime inicio = data.atStartOfDay();
//        LocalDateTime fim = data.atTime(LocalTime.MAX);
//
//        // Buscar os agendamentos naquela data
//        List<Agendamento> agendamentos = agendamentoService.buscarAgendamentosPorData(inicio, fim);
//        return ResponseEntity.ok(agendamentos);
//        }
//
////        // Caso nenhuma data seja fornecida, retornar todos os agendamentos
//        List<AgendamentoDTO> agendamentos = agendamentoService.buscarTodosAgendamentos();
//      return ResponseEntity.ok(agendamentos);
//}

    @GetMapping("/consultar")
    public List<AgendamentoDTO> buscarTodosAgendamentos() {
        return agendamentoService.buscarTodosAgendamentos();
    }
}
