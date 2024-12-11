package com.example.backend.repository;

import com.example.backend.models.agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<agendamento, Long> {
    // Adicione métodos customizados aqui, se necessário
}
