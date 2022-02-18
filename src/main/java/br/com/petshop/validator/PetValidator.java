package br.com.petshop.validator;

import br.com.petshop.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetValidator {

    public void validateNewPet(Pet pet) {
        if (pet.getIrAge() == null ||
                pet.getTxName() == null) {
            throw new RuntimeException("Invalid! Pet must have a name and age.");
        }

        if (pet.getIrAge() > 30) {
            throw new RuntimeException("Too old! Age not allowed for pets.");
        }
        if (pet.getIrAge() < 0) {
            throw new RuntimeException("Too young! Age not allowed for pets.");
        }
        if (pet.getTxName().length() < 2) {
            throw new RuntimeException("Invalid name! Must have more than 2 characters.");
        }
    }

}
