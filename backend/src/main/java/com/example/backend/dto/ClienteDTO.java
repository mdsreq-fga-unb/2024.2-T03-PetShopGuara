package com.example.backend.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String senha;

}
