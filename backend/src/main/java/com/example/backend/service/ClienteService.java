package com.example.backend.service;

import com.example.backend.models.Cliente;
import com.example.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente clienteId) {
        return clienteRepository.save(clienteId);
    }

    public void cancelarcliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
