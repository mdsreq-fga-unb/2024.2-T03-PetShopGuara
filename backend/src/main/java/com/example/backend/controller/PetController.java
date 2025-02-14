package com.example.backend.controller;

import com.example.backend.dto.PetDTO;
import com.example.backend.models.Pet;
import com.example.backend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"https://two024-2-t03-petshopguara-tlv0.onrender.com", "http://127.0.0.1:5501"})
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

    @GetMapping("/consultar/{petId}")
    public List<PetDTO> consultarDados(@PathVariable Long petId){
        return petService.consultarDadosPet(petId);
    }

    @GetMapping("/consultar")
    public List<PetDTO> listarPets() {
        return petService.listarPets();
    }
}
