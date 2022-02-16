/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.controller;

import br.com.petshop.model.Animal;
import br.com.petshop.service.AnimalService;
import br.com.petshop.util.AnimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author janderson
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalUtil animalUtil;

    @GetMapping("/insert/{name}/{age}")
    public Long insert(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        Animal animal = Animal.builder().txName(name).irAge(age).build();
        return animalService.save(animal);
    }

}
