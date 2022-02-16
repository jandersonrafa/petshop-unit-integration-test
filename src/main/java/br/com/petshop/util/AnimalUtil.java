package br.com.petshop.util;


import br.com.petshop.model.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalUtil {


    public Animal newRandomAnimal() {
        Animal items = new Animal();
        String randomData = "testedatatestedatatestedata";
        items.setTxName(randomData);
        items.setIrAge(2);
        return items;
    }

}
