package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Cliente;
import com.example.backend.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente clienteId) {
        return clienteRepository.save(clienteId);
    }

    public void cancelarCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
