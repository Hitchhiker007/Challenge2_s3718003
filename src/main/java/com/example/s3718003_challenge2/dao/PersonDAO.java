package com.example.s3718003_challenge2.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.s3718003_challenge2.model.Person;
import com.example.s3718003_challenge2.exception.AddResponse;
import com.example.s3718003_challenge2.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class PersonDAO {

    @Autowired
    PersonRepository personrep;

    public List<Person> getAllPersons()
    {
        return personrep.findAll();
    }

    public Person getPersonbyID(int id)
    {
        return personrep.findById(id).get();
    }
    //
    public Person getPersonbyName(String personName)
    {
        List<Person> persons=personrep.findAll();
        Person person = null;
        for(Person per:persons)
        {
            if(per.getName().equalsIgnoreCase(personName))
                person=per;
        }
        return person;
    }

    public Person addPerson(Person person)
    {
        person.setId(getMaxId());
        personrep.save(person);
        return person;
    }

    public int getMaxId()
    {
        return personrep.findAll().size()+1;
    }

    public Person updatePerson(Person person)
    {
        personrep.save(person);
        return person;
    }

    public AddResponse deletePerson(int id)
    {
        personrep.deleteById(id);
        AddResponse res= new AddResponse();
        res.setMsg("Person Deleted !");
        res.setId(id);
        return res;
    }

}