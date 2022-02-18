package br.com.petshop.service;

import br.com.petshop.model.Person;
import br.com.petshop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Long save(Person person) {
        return personRepository.save(person).getPersonId();
    }

    public Optional<Person> findById(Long petId) {
        return personRepository.findById(petId);
    }

}
