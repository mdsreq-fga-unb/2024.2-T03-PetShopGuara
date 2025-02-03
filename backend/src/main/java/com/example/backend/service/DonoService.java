package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.Exception.AutenticacaoDonoException;
import com.example.backend.dto.HorarioFuncionamentoDTO;
import com.example.backend.models.Dono;
import com.example.backend.repository.DonoRepository;

@Service
public class DonoService {

    private final DonoRepository donoRepository;

    public DonoService(DonoRepository donoRepository) {
        this.donoRepository = donoRepository;
    }

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
}
