package com.example.backend.dto;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AgendamentoDTO {
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
