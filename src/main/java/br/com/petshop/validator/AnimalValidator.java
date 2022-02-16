package br.com.petshop.validator;

import br.com.petshop.model.Animal;
import br.com.petshop.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AnimalValidator {

    public void validate(Animal animal) {
        if (animal.getIrAge() > 30) {
            throw new RuntimeException("Idade maior do que o permitido!");
        }
        if (animal.getIrAge() < 0) {
            throw new RuntimeException("Idade menor do que o permitido!");
        }
        if (animal.getTxName().length() < 2) {
            throw new RuntimeException("Nome inválido, deve conter mais que dois carácteres!");
        }
    }
}
