package br.com.petshop.service;

import br.com.petshop.model.People;
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
class PeopleServiceIntegrationTest {

    @Autowired
    private PeopleService peopleService;

    @DisplayName("EXEMPLO TESTE INTEGRADO: TESTE NECESSÁRIO")
    @Test
    public void whenValidPeople() {
        // Arrange
        People people = People.builder().txName("maoi").irAge(10).build();

        // Act
        Long peopleId = peopleService.save(people);

        // Assert
        Assertions.assertNotNull(peopleId);
        People peopleSaved = peopleService.findById(peopleId).get();


        assertAll("Should return people saved",
                () -> assertEquals(people.getPeopleId(), peopleSaved.getPeopleId()),
                () -> assertEquals(people.getIrAge(), peopleSaved.getIrAge())
        );
        // NAO DEVO VALIDAR CAMPOS NAO ESSENCIAIS

    }

}