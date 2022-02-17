package br.com.petshop.repository;

import br.com.petshop.model.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Long> {

}
