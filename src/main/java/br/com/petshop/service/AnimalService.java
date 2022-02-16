package br.com.petshop.service;

import br.com.petshop.model.Animal;
import br.com.petshop.repository.AnimalRepository;
import br.com.petshop.validator.AnimalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalValidator animalValidator;

    public Long save(Animal animal) {
        animalValidator.validate(animal);
        return animalRepository.save(animal).getAnimalId();
    }

    public Optional<Animal> findById(Long animalId) {
        return animalRepository.findById(animalId);
    }
}
