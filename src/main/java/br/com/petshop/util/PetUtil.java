package br.com.petshop.util;


import br.com.petshop.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetUtil {


    public Pet newRandomAnimal() {
        Pet items = new Pet();
        String randomData = "testedatatestedatatestedata";
        items.setTxName(randomData);
        items.setIrAge(2);
        return items;
    }

}
