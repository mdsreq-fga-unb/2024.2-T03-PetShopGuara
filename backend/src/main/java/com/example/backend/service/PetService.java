package com.example.backend.service;

import com.example.backend.models.Pet;
import com.example.backend.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet cadastrarPet(Pet pet) {
        return petRepository.save(pet);
    }

    public void cancelarPet(Long petId) {
        petRepository.deleteById(petId);
    }
}
