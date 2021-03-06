package br.com.petshop.service;

import br.com.petshop.model.Pet;
import br.com.petshop.repository.PetRepository;
import br.com.petshop.validator.PetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetValidator petValidator;

    @Autowired
    private PetRepository petRepository;

    public Long save(Pet pet) {
        petValidator.validateNewPet(pet);
        return petRepository.save(pet).getPetId();
    }

    public Optional<Pet> findById(Long petId) {
        return petRepository.findById(petId);
    }

}
