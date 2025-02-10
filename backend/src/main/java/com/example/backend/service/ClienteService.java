package com.example.backend.service;

import com.example.backend.Exception.ClienteException;
import com.example.backend.Exception.EmailNotFoundException;
import com.example.backend.Exception.IncorrectPasswordException;
import com.example.backend.dto.ClienteDTO;
import com.example.backend.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.models.Cliente;
import com.example.backend.repository.ClienteRepository;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Cliente cadastrarCliente(Cliente clienteId) {
        return clienteRepository.save(clienteId);
    }

    public void cancelarCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public ClienteDTO consultarDadosCliente(Long clienteId) {
        Optional<Cliente> clienteExist = clienteRepository.findById(clienteId);
        if(clienteExist.isPresent()){ // verifica se existe o cliente
            ClienteDTO clienteDto = new ClienteDTO(); // cria uma instância do clienteDto
            clienteDto.setId(clienteExist.get().getId()); // tira do optional
            clienteDto.setNome(clienteExist.get().getNome());
            clienteDto.setEmail(clienteExist.get().getEmail());
            clienteDto.setTelefone(clienteExist.get().getTelefone());
            clienteDto.setEndereco(clienteExist.get().getEndereco());

            return clienteDto;
        }
        else{
            throw new ClienteException("Cliente não existe!"); // mensagem de erro
        }
    }
    private void validarSenha(String senhaInformada, String senhaArmazenada) {
        if (!senhaInformada.equals(senhaArmazenada)) {
            throw new IncorrectPasswordException("Senha incorreta");
        }
    }

    public Cliente autenticar(String email, String senha) {
        Cliente cliente = (Cliente) clienteRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email não encontrado"));

        validarSenha(senha, cliente.getSenha());

        return cliente;
    }
}
