package br.com.petshop.repository;

import br.com.petshop.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

}
