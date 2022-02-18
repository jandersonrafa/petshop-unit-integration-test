/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.controller;

import br.com.petshop.model.Person;
import br.com.petshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author janderson
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/insert/{name}/{age}")
    public Long insert(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        Person people = Person.builder().txName(name).irAge(age).build();
        return personService.save(people);
    }

}
