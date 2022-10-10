package com.example.s3718003_challenge2.controller;
import com.example.s3718003_challenge2.dao.PersonDAO;
import com.example.s3718003_challenge2.exception.AddResponse;
import com.example.s3718003_challenge2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class person_controller {

    @Autowired
    PersonDAO PersonDAO;


    @GetMapping()
    public List getAllPersons()
    {
        return PersonDAO.getAllPersons();
    }

    @GetMapping("person/{id}")
    public Person getPersonbyID(@PathVariable(value="id") int id)
    {
        return PersonDAO.getPersonbyID(id);
    }

    @GetMapping("person/personName")
    public Person getPersonbyname(@PathVariable(value="name") String personName)
    {
        return PersonDAO.getPersonbyName(personName);
    }

    @PostMapping()
    public Person addPerson(@RequestBody Person Person)
    {
        return PersonDAO.addPerson(Person);
    }

    @PutMapping()
    public Person updatePerson(@RequestBody Person Person)
    {
        return PersonDAO.updatePerson(Person);
    }

    @DeleteMapping("/deleteperson/{id}")
    public AddResponse deletePerson(@PathVariable(value = "id")int id)
    {
        return PersonDAO.deletePerson(id);
    }
}

