package com.example.s3718003_challenge2.controller;
import com.example.s3718003_challenge2.dao.PersonDAO;
import com.example.s3718003_challenge2.exception.AddResponse;
import com.example.s3718003_challenge2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/person")
public class person_controller {

    @Autowired
    PersonDAO PersonDAO;


    @GetMapping("/getperson")
    public ResponseEntity<List<Person>> getAllPersons()
    {
        try{
            List<Person> persons = PersonDAO.getAllPersons();
            return new ResponseEntity<List<Person>>(persons, HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("person/{id}")
    public ResponseEntity<Person> getPersonbyID(@PathVariable(value="id") int id)
    {
        try
        {
            Person person  = PersonDAO.getPersonbyID(id);
            return new ResponseEntity<Person>(person,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("person/personName")
    public ResponseEntity<Person> getPersonbyname(@PathVariable(value="name") String personName)
    {
        try
        {
            Person person  = PersonDAO.getPersonbyName(personName);
            return new ResponseEntity<Person>(person,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addperson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person)
    {
      try{
          person = PersonDAO.addPerson(person);
          return new ResponseEntity<Person>(person,HttpStatus.CREATED);
      }
      catch(NoSuchElementException e)
      {
          return new ResponseEntity<>(HttpStatus.CONFLICT);
      }
    }
    //
    @PutMapping("/updateperson/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value="id") int id, @RequestBody Person person)
    {
        try {
                Person existPerson = PersonDAO.getPersonbyID(id);
                existPerson.setName(person.getName());
                existPerson.setAddress(person.getAddress());
                existPerson.setPostcode(person.getPostcode());
                existPerson.setAge(person.getAge());
                existPerson.setJob(person.getJob());
                existPerson.setEmail(person.getEmail());
                existPerson.setPhoneno(person.getPhoneno());

                Person updated_person = PersonDAO.updatePerson(existPerson);
                return new ResponseEntity<Person>(updated_person,HttpStatus.OK);
            }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteperson/{id}")
    public AddResponse deletePerson(@PathVariable(value = "id")int id)
    {
        return PersonDAO.deletePerson(id);
    }
}

