package br.com.petshop.service;

import br.com.petshop.model.Person;
import br.com.petshop.repository.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService peopleService;

    @Mock
    private PersonRepository peopleRepository;

    @DisplayName("EXEMPLO TESTE INTEGRADO: TESTE DESNECESSARIO")
    @Test
    public void whenValidPeople() {
        // Arrange
        Person people = Person.builder().txName("maoi").irAge(10).build();
        when(peopleRepository.save(people)).thenReturn(people);

        // Act
        Long peopleId = peopleService.save(people);

        // Assert
        verify(peopleRepository).save(people);
    }

}