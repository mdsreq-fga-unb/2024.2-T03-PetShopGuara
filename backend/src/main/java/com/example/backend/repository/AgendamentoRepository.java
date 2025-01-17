package com.example.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.models.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Buscar todos os agendamentos entre duas datas
    List<Agendamento> findByDataHoraBetween(LocalDateTime start, LocalDateTime end);

    List<Agendamento> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);


    
}
