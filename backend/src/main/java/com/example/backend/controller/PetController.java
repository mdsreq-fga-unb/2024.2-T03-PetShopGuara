package com.example.backend.controller;

import com.example.backend.models.Pet;
import com.example.backend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/cadastrar")
    public Pet cadastrarPet(@RequestBody Pet pet) {
        return petService.cadastrarPet(pet);
    }

    @DeleteMapping("/cancelar/{id}")
    public void cancelarPet(@PathVariable Long id) {
        petService.cancelarPet(id);
    }
}
