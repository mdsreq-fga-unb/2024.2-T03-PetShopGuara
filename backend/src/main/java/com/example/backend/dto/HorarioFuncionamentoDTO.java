package com.example.backend.dto;

import java.time.LocalTime;
import lombok.Data;

@Data
public class HorarioFuncionamentoDTO {
    private LocalTime abertura;
    private LocalTime fechamento;
    private boolean sabadoPorOrdemDeChegada;
}
