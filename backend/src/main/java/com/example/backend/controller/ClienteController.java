package com.example.backend.controller;

import com.example.backend.dto.ClienteDTO;
import com.example.backend.models.Cliente;
import com.example.backend.models.Funcionario;
import com.example.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/donos")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody Map<String, String> credenciais) {
        String email = credenciais.get("email");
        String senha = credenciais.get("senha");

        Cliente cliente = clienteService.autenticar(email, senha);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/cadastrar")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }

    @DeleteMapping("/cancelar/{id}")
    public void cancelarCliente(@PathVariable Long id) {
        clienteService.cancelarCliente(id); // Passando o id para o serviço
    }
    @PostMapping("/consultar/{clienteId}")
    public ClienteDTO consultarDados(@PathVariable Long clienteId) {
        return clienteService.consultarDadosCliente(clienteId);
    }
}

