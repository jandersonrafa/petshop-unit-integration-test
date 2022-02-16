package br.com.petshop.service;

import br.com.petshop.model.Animal;
import br.com.petshop.repository.AnimalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class AnimalServiceIntegrationTest {

    @Autowired
    private AnimalService animalService;

    @Test
    public void whenValidAnimal() {
        // Arrange
        Animal animal = Animal.builder().txName("maoi").irAge(10).build();

        // Act
        Long animalId = animalService.save(animal);

        // Assert
        Assertions.assertNotNull(animalId);
        Animal animalSaved = animalService.findById(animalId).get();


        assertAll("Should return animal saved",
                () -> assertEquals(animal.getAnimalId(), animalSaved.getAnimalId()),
                () -> assertEquals(animal.getIrAge(), animalSaved.getIrAge())
        );

    }
}