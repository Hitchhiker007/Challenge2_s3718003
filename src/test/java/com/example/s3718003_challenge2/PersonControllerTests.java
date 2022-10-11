package com.example.s3718003_challenge2;

import com.example.s3718003_challenge2.controller.person_controller;
import com.example.s3718003_challenge2.dao.PersonDAO;
import com.example.s3718003_challenge2.model.Person;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {PersonControllerTests.class})
public class PersonControllerTests {

    @Mock
    PersonDAO PersonDAO;

    @InjectMocks
    person_controller person_controller;

    List<Person> mypersons;
    Person person;

    @Test
    @Order(1)
    public void test_getAllPersons(){

        //Mock list as it is not using the database
        mypersons = new ArrayList<Person>();
        mypersons.add(new Person(1, "Kyle", "Sunny Court", 3028, 27, "Surgeon", "Kyle@gmail.com", "04687529"));
        mypersons.add(new Person(2, "Jacob", "Mcnaven Court", 3027, 31, "Fisherman", "Fish@gmail.com", "04687589"));

        when(PersonDAO.getAllPersons()).thenReturn(mypersons); //Mock
        //This will not talk to the database but will go straight to the getAllPersons() method in the controller
        ResponseEntity<List<Person>> res = person_controller.getAllPersons();

        //Validation
        assertEquals(HttpStatus.FOUND, res.getStatusCode());
        assertEquals(2, res.getBody().size());
    }

    @Test
    @Order(2)
    public void test_getPersonbyId(){
        person = new Person(2, "Jack", "Watery Court", 3025, 41,
                "Rogue", "Rogue@gmail.com", "04687896");
        int personID = 2;

        when(PersonDAO.getPersonbyID(personID)).thenReturn(person);
        ResponseEntity<Person> res = person_controller.getPersonbyID(personID);

        //Validation
        //assertEquals(HttpStatus.FOUND, res.getStatusCode());
        assertEquals(personID, res.getBody().getId());
    }

    @Test
    @Order(3)
    public void test_addPerson(){

        person = new Person(3, "Jacob", "Dry Court", 3027, 38,
                "Rogue", "Rogue@gmail.com", "04687896");
        when(PersonDAO.addPerson(person)).thenReturn(person);
        ResponseEntity<Person> res = person_controller.addPerson(person);

        assertEquals(HttpStatus.CREATED, res.getStatusCode());
        assertEquals(person, res.getBody());

    }
}
