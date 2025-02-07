package com.example.backend.repository;

import com.example.backend.models.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
