package br.com.petshop.service;

import br.com.petshop.model.People;
import br.com.petshop.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository pessoaRepository;

    public Long save(People pessoa) {
        return pessoaRepository.save(pessoa).getPeopleId();
    }

    public Optional<People> findById(Long animalId) {
        return pessoaRepository.findById(animalId);
    }
}
