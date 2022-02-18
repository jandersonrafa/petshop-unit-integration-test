package br.com.petshop.service;

import br.com.petshop.model.Pet;
import br.com.petshop.validator.PetValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PetValidatorTest {

    @InjectMocks
    private PetValidator petValidator;

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void whenValidAnimal () {
        // Arrange
        Pet pet = Pet.builder().txName("maoi").irAge(10).build();

        // Act
        petValidator.validate(pet);

        // Assert
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void whenInvalidAnimalAge () {
        // Arrange
        Pet pet = Pet.builder().txName("maoi").irAge(31).build();

        // Act
        // Assert
        RuntimeException exception =  assertThrows(RuntimeException.class, () ->  petValidator.validate(pet));
        Assertions.assertEquals("Idade maior do que o permitido!", exception.getMessage());
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void whenInvalidAnimalName () {
        // Arrange
        Pet pet = Pet.builder().txName("t").irAge(10).build();

        // Act
        // Assert
        RuntimeException exception =  assertThrows(RuntimeException.class, () ->  petValidator.validate(pet));
        Assertions.assertEquals("Nome inválido, deve conter mais que dois carácteres!", exception.getMessage());
    }

}