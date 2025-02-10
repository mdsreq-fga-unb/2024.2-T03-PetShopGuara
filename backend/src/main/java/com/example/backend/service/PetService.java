package com.example.backend.service;

import com.example.backend.Exception.PetException;
import com.example.backend.dto.ClienteDTO;
import com.example.backend.dto.PetDTO;
import com.example.backend.models.Pet;
import com.example.backend.repository.ClienteRepository;
import com.example.backend.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PetRepository petRepository;

    public Pet cadastrarPet(Pet pet) {
        return petRepository.save(pet);
    }

    public void cancelarPet(Long petId) {
        petRepository.deleteById(petId);
    }

    public List<PetDTO> consultarDadosPet(Long clienteId){
        List<Pet> petExist = petRepository.findByDonoId(clienteId);
        List<PetDTO> petDTOs = new ArrayList<>();
        if(!petExist.isEmpty()){
            for (Pet pet : petExist) {
                PetDTO petDto = new PetDTO(); // cria uma instância do PetDTO
                petDto.setId(pet.getId());

                ClienteDTO clienteDTO = criarClienteDTO(Optional.of(pet));

                petDto.setClienteId(clienteDTO);
                petDto.setNome(pet.getNome());
                petDto.setCor(pet.getCor());
                petDto.setIdade(pet.getIdade());
                petDto.setSexo(pet.getSexo());
                petDto.setEspecie(pet.getEspecie());
                petDto.setRaca(pet.getRaca());
                petDto.setObservacao(pet.getObservacao());
                // Outros atributos do PetDTO que você precise setar
                petDTOs.add(petDto);
            }// verifica se existe o pet

            return petDTOs;
        }
        else{
            throw new PetException("Pet não existe!"); // mensagem de erro
        }

    }

    private static ClienteDTO criarClienteDTO(Optional<Pet> petExist) {
        ClienteDTO clienteDTO = new ClienteDTO();

        petExist.stream().forEach(pet -> {
            clienteDTO.setId(pet.getId());
            clienteDTO.setNome(pet.getNome());
        });
        return clienteDTO;
    }

    public List<PetDTO> listarPets() {
        List<Pet> petExist = petRepository.findAll();
        List<PetDTO> petDTOs = new ArrayList<>();
        if(!petExist.isEmpty()){
            for (Pet pet : petExist) {
                PetDTO petDto = new PetDTO(); // cria uma instância do PetDTO
                petDto.setId(pet.getId());

                ClienteDTO clienteDTO = criarClienteDTO(Optional.of(pet));

                petDto.setClienteId(clienteDTO);
                petDto.setNome(pet.getNome());
                petDto.setCor(pet.getCor());
                petDto.setIdade(pet.getIdade());
                petDto.setSexo(pet.getSexo());
                petDto.setEspecie(pet.getEspecie());
                petDto.setRaca(pet.getRaca());
                petDto.setObservacao(pet.getObservacao());
                // Outros atributos do PetDTO que você precise setar
                petDTOs.add(petDto);
            }// verifica se existe o pet

            return petDTOs;
        }
        else{
            throw new PetException("Pet não existe!"); // mensagem de erro
        }
    }
}
