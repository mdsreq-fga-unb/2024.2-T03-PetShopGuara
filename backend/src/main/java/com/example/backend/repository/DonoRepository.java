package com.example.backend.repository;

import com.example.backend.models.Dono;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonoRepository extends JpaRepository<Dono, Long> {
    Optional<Dono> findByEmail(String email);
}
