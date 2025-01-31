package com.example.backend.controller;

import com.example.backend.models.Agendamento;
import com.example.backend.models.Funcionario;
import com.example.backend.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
/*
    @PostMapping("/login")
    public ResponseEntity<Funcionario> login(@RequestBody Map<String, String> credenciais) {
        String email = credenciais.get("email");
        String senha = credenciais.get("senha");

        Funcionario funcionario = funcionarioService.autenticar(email, senha);
        return ResponseEntity.ok(funcionario);
    }
*/
    @GetMapping("/agendamentos")
    public ResponseEntity<List<Agendamento>> getAgendamentosDoDia() {
        List<Agendamento> agendamentos = funcionarioService.getAgendamentosDoDia();
        return ResponseEntity.ok(agendamentos);
    }
}
