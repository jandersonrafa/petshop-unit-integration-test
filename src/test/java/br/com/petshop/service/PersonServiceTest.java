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
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @DisplayName("EXEMPLO TESTE UNITARIO: TESTE DESNECESSARIO")
    @Test
    public void shouldSavePerson() {
        // arrange
        Person person = Person.builder().txName("Maoi").irAge(10).build();
        when(personRepository.save(person)).thenReturn(person);

        // act
        Long personId = personService.save(person);

        // assert
        verify(personRepository).save(person);
    }

}