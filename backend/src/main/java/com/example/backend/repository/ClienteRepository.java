package com.example.backend.repository;

import com.example.backend.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Object> findByEmail(String email);
}
