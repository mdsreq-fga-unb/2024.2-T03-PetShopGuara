package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PetDTO {
    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private ClienteDTO clienteId;
    private String cor;
    private Long idade;
    private String observacao;
    private String sexo;




}
