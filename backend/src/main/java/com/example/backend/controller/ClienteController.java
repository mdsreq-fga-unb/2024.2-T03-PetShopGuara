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

    @PostMapping("/cadastrar")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        System.out.println("Cadastrando Cliente");
        return clienteService.cadastrarCliente(cliente);
    }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<Cliente> login(@PathVariable String email, @PathVariable String senha) {
        Cliente cliente = clienteService.autenticar(email, senha);
        return ResponseEntity.ok(cliente);
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

