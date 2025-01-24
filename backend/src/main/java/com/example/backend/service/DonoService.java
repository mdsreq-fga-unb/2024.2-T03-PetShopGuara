package com.example.backend.service;

import com.example.backend.Exception.AutenticacaoDonoException;
import com.example.backend.models.Dono;
import com.example.backend.repository.DonoRepository;
import org.springframework.stereotype.Service;

@Service
public class DonoService {

    private final DonoRepository donoRepository;

    public DonoService(DonoRepository donoRepository) {
        this.donoRepository = donoRepository;
    }

    // Verificar se o email e a senha correspondem ao dono
    public Dono autenticarDono(String email, String senha) {
        Dono dono = donoRepository.findByEmail(email)
                .orElseThrow(() -> new AutenticacaoDonoException("Email inválido."));

        if (!dono.getSenha().equals(senha)) {
            throw new AutenticacaoDonoException("Senha incorreta.");
        }

        return dono;
    }
}
