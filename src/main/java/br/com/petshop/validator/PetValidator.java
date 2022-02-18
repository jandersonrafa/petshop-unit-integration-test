package br.com.petshop.validator;

import br.com.petshop.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetValidator {

    public void validate(Pet pet) {
        if (pet.getIrAge() > 30) {
            throw new RuntimeException("Idade maior do que o permitido!");
        }
        if (pet.getIrAge() < 0) {
            throw new RuntimeException("Idade menor do que o permitido!");
        }
        if (pet.getTxName().length() < 2) {
            throw new RuntimeException("Nome inválido, deve conter mais que dois carácteres!");
        }
    }
}
