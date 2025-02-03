package  com.example.backend.dto;

import java.time.LocalTime;

public class HorarioFuncionamentoDTO {
    private LocalTime abertura;
    private LocalTime fechamento;
    private boolean sabadoPorOrdemDeChegada;

    public LocalTime getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalTime abertura) {
        this.abertura = abertura;
    }

    public LocalTime getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalTime fechamento) {
        this.fechamento = fechamento;
    }

    public boolean isSabadoPorOrdemDeChegada() {
        return sabadoPorOrdemDeChegada;
    }

    public void setSabadoPorOrdemDeChegada(boolean sabadoPorOrdemDeChegada) {
        this.sabadoPorOrdemDeChegada = sabadoPorOrdemDeChegada;
    }
}
