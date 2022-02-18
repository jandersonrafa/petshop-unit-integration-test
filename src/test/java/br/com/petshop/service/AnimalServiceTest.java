package br.com.petshop.service;

import br.com.petshop.model.Animal;
import br.com.petshop.repository.AnimalRepository;
import br.com.petshop.validator.AnimalValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    @InjectMocks
    private AnimalService animalService;

    @Mock
    private AnimalValidator animalValidator;

    @Mock
    private AnimalRepository animalRepository;

    @DisplayName("EXEMPLO TESTE INTEGRADO E UNITARIO: TESTE NECESSÁRIO")
//    @DisplayName("NECESSARIO PORQUE MOCKBEAN E SPYBEAN RESETA CONTEXTO E FICA LENTO SE FAZER NO PROPRIO,MOSTRAR CODIGO COMENTADO")
    @Test
//    @Disabled
    public void whenValidAnimal() {
        // Arrange
        Animal animal = Animal.builder().txName("maoi").irAge(10).build();
        when(animalRepository.save(animal)).thenReturn(animal);

        // Act
        Long animalId = animalService.save(animal);

        // Assert
        verify(animalValidator).validate(animal);
    }

}