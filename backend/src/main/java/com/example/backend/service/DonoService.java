package com.example.backend.service;

import com.example.backend.models.Dono;
import com.example.backend.repository.DonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonoService {

    @Autowired
    private DonoRepository donoRepository;

    public Dono cadastrarDono(Dono dono) {
        return donoRepository.save(dono);
    }

    public void cancelarDono(Long donoId) {
        donoRepository.deleteById(donoId);
    }
}
