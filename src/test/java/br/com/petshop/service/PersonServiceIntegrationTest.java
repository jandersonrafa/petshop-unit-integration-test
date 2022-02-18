package br.com.petshop.service;

import br.com.petshop.model.Person;
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
class PersonServiceIntegrationTest {

    @Autowired
    private PersonService personService;

    @DisplayName("EXEMPLO TESTE INTEGRADO: TESTE NECESSÁRIO")
    @Test
    public void shouldSavePerson() {
        // arrange
        Person people = Person.builder().txName("Maoi").irAge(10).build();

        // act
        Long peopleId = personService.save(people);

        // assert
        Assertions.assertNotNull(peopleId);
        Person personSaved = personService.findById(peopleId).get();


        assertAll("Should return people saved",
                () -> assertEquals(people.getPersonId(), personSaved.getPersonId()),
                () -> assertEquals(people.getIrAge(), personSaved.getIrAge())
        );
        // NAO SERIA NECESSARIO VALIDAR CAMPOS NAO ESSENCIAIS
    }

}