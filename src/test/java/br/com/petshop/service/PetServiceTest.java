package br.com.petshop.service;

import br.com.petshop.model.Pet;
import br.com.petshop.repository.PetRepository;
import br.com.petshop.validator.PetValidator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @InjectMocks
    private PetService petService;

    @Mock
    private PetValidator petValidator;

    @Mock
    private PetRepository petRepository;

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
//    @DisplayName("NECESSARIO PORQUE MOCKBEAN E SPYBEAN RESETA CONTEXTO E FICA LENTO SE FIZER NO PROPRIO, MOSTRAR CODIGO COMENTADO")
    @Test
    @Disabled
    public void shouldSavePet() {
        // arrange
        Pet pet = Pet.builder().txName("Maoi").irAge(10).build();
        when(petRepository.save(pet)).thenReturn(pet);

        // act
        Long petId = petService.save(pet);

        // assert
        verify(petValidator).validateNewPet(pet);
    }

}