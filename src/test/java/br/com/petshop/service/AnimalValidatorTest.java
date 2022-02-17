package br.com.petshop.service;

import br.com.petshop.model.Animal;
import br.com.petshop.validator.AnimalValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AnimalValidatorTest {

    @InjectMocks
    private AnimalValidator animalValidator;

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void whenValidAnimal () {
        // Arrange
        Animal animal = Animal.builder().txName("maoi").irAge(10).build();

        // Act
        animalValidator.validate(animal);

        // Assert
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void whenInvalidAnimalAge () {
        // Arrange
        Animal animal = Animal.builder().txName("maoi").irAge(31).build();

        // Act
        // Assert
        RuntimeException exception =  assertThrows(RuntimeException.class, () ->  animalValidator.validate(animal));
        Assertions.assertEquals("Idade maior do que o permitido!", exception.getMessage());
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void whenInvalidAnimalName () {
        // Arrange
        Animal animal = Animal.builder().txName("t").irAge(10).build();

        // Act
        // Assert
        RuntimeException exception =  assertThrows(RuntimeException.class, () ->  animalValidator.validate(animal));
        Assertions.assertEquals("Nome inválido, deve conter mais que dois carácteres!", exception.getMessage());
    }

}