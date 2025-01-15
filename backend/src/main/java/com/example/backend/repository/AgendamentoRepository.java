package com.example.backend.repository;

import com.example.backend.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Buscar todos os agendamentos entre duas datas
    List<Agendamento> findByDataHoraBetween(LocalDateTime start, LocalDateTime end);
}
