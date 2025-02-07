package com.example.backend.repository;

import com.example.backend.models.Pet;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet>findByDonoId(Long donoId);
}
