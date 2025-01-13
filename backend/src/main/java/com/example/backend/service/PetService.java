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

    public PetDTO consultarDadosPet(Long petId){
        Optional<Pet> petExist = petRepository.findById(petId);
        if(petExist.isPresent<>){ // verifica se existe o pet
            PetDTO petDto = new PetDTO(); // cria uma instância do PetDTO
            petDto.setId(petExist.get().getId()); // tira do optional
            petDto.setNome(petExist.get().getNome());
            petDto.setEspecie(petExist.get().getEspecie());
            petDto.setRaca(petExist.get().getRaca());
            petDto.setDonoId(petExist.get().getDonoId());

            return petDto;
        }
        else{
            throw new PetException("Pet não existe!"); // mensagem de erro
        }
    }
}
