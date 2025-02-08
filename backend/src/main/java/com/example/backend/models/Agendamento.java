package com.example.backend.models;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="pet_id")
    private Integer pet;

    @Column(name="cliente_id")
    private Integer cliente;

    @Column(name= "dataHoraAgendamento")
    private Date dataHora;

    @Column(name = "servico")
    private String servico;

    @Column(name = "valor")
    private double valor;

}
