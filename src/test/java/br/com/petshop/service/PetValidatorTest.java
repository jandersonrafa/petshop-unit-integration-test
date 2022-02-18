package br.com.petshop.service;

import br.com.petshop.model.Pet;
import br.com.petshop.validator.PetValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PetValidatorTest {

    @InjectMocks
    private PetValidator petValidator;

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void shouldValidateNewPet() {
        // arrange
        Pet pet = Pet.builder().txName("Maoi").irAge(10).build();

        // act && assert
        assertDoesNotThrow(() -> petValidator.validateNewPet(pet));
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void shouldThrowExceptionWhenPetAgeIsAbove30() {
        // arrange
        Pet pet = Pet.builder().txName("Maoi").irAge(31).build();

        // act && assert
        assertThrows(RuntimeException.class, () -> petValidator.validateNewPet(pet));
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void shouldThrowExceptionWhenPetAgeIsUnder0() {
        // arrange
        Pet pet = Pet.builder().txName("Maoi").irAge(-1).build();

        // act && assert
        assertThrows(RuntimeException.class, () -> petValidator.validateNewPet(pet));
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void shouldThrowExceptionWhenPetNameIsTooShort() {
        // arrange
        Pet pet = Pet.builder().txName("t").irAge(10).build();

        // act && assert
        assertThrows(RuntimeException.class, () -> petValidator.validateNewPet(pet));
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void shouldThrowExceptionWhenPetNameIsNull() {
        // arrange
        Pet pet = Pet.builder().txName("t").irAge(10).build();

        // act && assert
        assertThrows(RuntimeException.class, () -> petValidator.validateNewPet(pet));
    }

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void shouldThrowExceptionWhenPetAgeIsNull() {
        // arrange
        Pet pet = Pet.builder().txName("t").irAge(10).build();

        // act && assert
        assertThrows(RuntimeException.class, () -> petValidator.validateNewPet(pet));
    }

}