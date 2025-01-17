package com.example.backend.controller;

import com.example.backend.models.Cliente;
import com.example.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donos")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }

    @DeleteMapping("/cancelar/{id}")
    public void cancelarCliente(@PathVariable Long id) {
        clienteService.cancelarCliente(id); // Passando o id para o serviço
    }
}

