package br.com.petshop.service;

import br.com.petshop.model.Animal;
import br.com.petshop.model.People;
import br.com.petshop.repository.PeopleRepository;
import br.com.petshop.validator.AnimalValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

    @InjectMocks
    private PeopleService peopleService;

    @Mock
    private PeopleRepository peopleRepository;

    @DisplayName("EXEMPLO TESTE INTEGRADO: TESTE DESNECESSARIO")
    @Test
    public void whenValidPeople() {
        // Arrange
        People people = People.builder().txName("maoi").irAge(10).build();
        when(peopleRepository.save(people)).thenReturn(people);

        // Act
        Long peopleId = peopleService.save(people);

        // Assert
        verify(peopleRepository).save(people);

    }

}