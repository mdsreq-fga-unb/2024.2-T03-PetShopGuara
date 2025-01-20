package com.example.backend.service;

import com.example.backend.Exception.PetException;
import com.example.backend.dto.PetDTO;
import com.example.backend.models.Pet;
import com.example.backend.repository.PetRepository;

import java.util.Optional;

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
        if(petExist.isPresent()){ // verifica se existe o pet
            PetDTO petDto = new PetDTO(); // cria uma instância do PetDTO
            petDto.setId(petExist.get().getId());// tira do optional
            petDto.setClienteId(petExist.get().getDonoId());
            petDto.setNome(petExist.get().getNome());
            petDto.setCor(petExist.get().getCor());
            petDto.setIdade(petExist.get().getIdade());
            petDto.setSexo(petExist.get().getSexo());
            petDto.setEspecie(petExist.get().getEspecie());
            petDto.setRaca(petExist.get().getRaca());
            petDto.setObservacao(petExist.get().getObservacao());

            return petDto;
        }
        else{
            throw new PetException("Pet não existe!"); // mensagem de erro
        }
    }
}
