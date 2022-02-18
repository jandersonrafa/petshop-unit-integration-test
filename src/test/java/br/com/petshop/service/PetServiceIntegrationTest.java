package br.com.petshop.service;

import br.com.petshop.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PetServiceIntegrationTest {

    @Autowired
    private PetService petService;

//    @SpyBean
//    private

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
    @Test
    public void shouldSavePet() {
        // arrange
        Pet pet = Pet.builder().txName("Maoi").irAge(10).build();

        // act
        Long petId = petService.save(pet);

        // assert
        Assertions.assertNotNull(petId);
        Pet savedPet = petService.findById(petId).get();

        assertAll("Should return saved pet",
                () -> assertEquals(pet.getPetId(), savedPet.getPetId()),
                () -> assertEquals(pet.getIrAge(), savedPet.getIrAge())
        );
    }

}