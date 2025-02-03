package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.Exception.IncorrectPasswordException;
import com.example.backend.Exception.EmailNotFoundException;
import com.example.backend.models.Agendamento;
import com.example.backend.models.Funcionario;
import com.example.backend.repository.AgendamentoRepository;
import com.example.backend.repository.FuncionarioRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Funcionario autenticar(String email, String senha) {
        Funcionario funcionario = funcionarioRepository.findByEmail(email)
               .orElseThrow(() -> new EmailNotFoundException("Email não encontrado"));

        validarSenha(senha, funcionario.getSenha());

        return funcionario;
    }

    private void validarSenha(String senhaInformada, String senhaArmazenada) {
        if (!passwordEncoder.matches(senhaInformada, senhaArmazenada)) {
            throw new IncorrectPasswordException("Senha incorreta");
        }
    }

    // Método para buscar agendamentos do dia
    public List<Agendamento> getAgendamentosDoDia() {
        LocalDate hoje = LocalDate.now(); // Data de hoje
        LocalDateTime inicioDoDia = hoje.atStartOfDay(); // Início do dia
        LocalDateTime fimDoDia = hoje.atTime(18, 00, 00); // Fim do dia

        // Consulta os agendamentos entre o início e o fim do dia
        return agendamentoRepository.findByDataHoraBetween(inicioDoDia, fimDoDia);
    }
}
