package com.example.s3718003_challenge2.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.s3718003_challenge2.model.Person;
import com.example.s3718003_challenge2.exception.AddResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    static HashMap<Integer,Person> personIDMap;

    public AccountDAO()
    {
        personIDMap = new HashMap<Integer,Person>();

        Person jeffPerson = new Person(1, "Jeff", "Sunny Court", 4029, 35, "FireMan", "skux@gmail.com", "0468659988");
        Person michaelPerson = new Person(2, "Michael", "Dark Court", 5029, 19, "Policeman", "police@gmail.com", "04688976435");
        Person lokeshPerson = new Person(3, "Lokesh", "Mid Court", 3028, 28, "Doctor", "doctor@gmail.com", "0468684897");

        personIDMap.put(1,jeffPerson);
        personIDMap.put(2,michaelPerson);
        personIDMap.put(3,lokeshPerson);
    }

    public List getAllPersons()
    {
        List persons = new ArrayList(personIDMap.values());
        return persons;
    }

    public Person getPersonbyID(int id)
    {
        Person Person = personIDMap.get(id);
        return Person;
    }

    public Person getPersonbyName(String personName)
    {
        Person Person = null;
        for (int i:personIDMap.keySet())
        {
            if(personIDMap.get(i).getName().equals(personName))
                Person = personIDMap.get(i);
        }
        return Person;
    }

    public Person addPerson(Person Person)
    {
        Person.setId(getMaxId());
        personIDMap.put(Person.getId(), Person);
        return Person;
    }

    public static int getMaxId()
    {
        int max=0;
        for (int id: personIDMap.keySet())
            if(max<=id)
                max=id;
        return max+1;
    }

    public Person updatePerson(Person Person)
    {
        if(Person.getId()>0)
            personIDMap.put(Person.getId(), Person);
        return Person;
    }

    public AddResponse deletePerson(int id)
    {
        personIDMap.remove(id);
        AddResponse res = new AddResponse();
        res.setMsg("Person has been deleted");
        res.setId(id);
        return res;
    }

}