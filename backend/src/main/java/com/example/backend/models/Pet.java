package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private String cor;
    private Long idade;
    private String observacao;
    private String sexo;

    @ManyToOne
    @JoinColumn(name="donoId",  nullable = true)
    private Cliente dono;

    }

