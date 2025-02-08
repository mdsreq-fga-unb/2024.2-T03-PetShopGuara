package com.example.backend.models;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name= "dataHoraAgendamento")
    private LocalDateTime dataHora;


    @Enumerated(EnumType.STRING) // Mapeia o enum como uma string no banco de dados
    @Column(name = "servico")
    private Servico servico;

    @Column(name = "valor")
    private double valor;

}
