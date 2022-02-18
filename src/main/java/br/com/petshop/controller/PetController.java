/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.controller;

import br.com.petshop.model.Pet;
import br.com.petshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author janderson
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/insert/{name}/{age}")
    public Long insert(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        Pet pet = Pet.builder().txName(name).irAge(age).build();
        return petService.save(pet);
    }

}
