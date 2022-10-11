package com.example.s3718003_challenge2;

import com.example.s3718003_challenge2.controller.account_controller;
import com.example.s3718003_challenge2.dao.AccountDAO;
import com.example.s3718003_challenge2.model.Account;
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
@SpringBootTest(classes = {AccountControllerTests.class})
public class AccountControllerTests {

    @Mock
    AccountDAO AccountDAO;

    @InjectMocks
    account_controller account_controller;

    List<Account> myaccounts;
    Account account;

    @Test
    @Order(1)
    public void test_getAllAccounts(){

        //Mock list as it is not using the database
        myaccounts= new ArrayList<Account>();
        myaccounts.add(new Account(1, "Loan", "243", "Jacob", 300, "11-11-2022"));
        myaccounts.add(new Account(2, "Saving", "592", "Justin",350, "11-11-2022"));

        when(AccountDAO.getAllAccounts()).thenReturn(myaccounts); //Mock
        //This will not talk to the databse but will go straight to the getAllPersons() method in the controller
        ResponseEntity<List<Account>> res = account_controller.getAllAccounts();

        //Validation
        assertEquals(HttpStatus.FOUND, res.getStatusCode());
        assertEquals(2, res.getBody().size());
    }

    @Test
    @Order(2)
    public void test_getAccountbyId(){
        account = new Account(1, "Saving", "786", "Liam", 500, "11-11-2022");
        int accountID = 1;

        when(AccountDAO.getAccountbyID(accountID)).thenReturn(account);
        ResponseEntity<Account> res = account_controller.getAccountbyID(accountID);

        //Validation
        //assertEquals(HttpStatus.FOUND, res.getStatusCode());
        assertEquals(accountID, res.getBody().getId());
    }

    @Test
    @Order(3)
    public void test_addAccount(){

        account = new Account(1, "Saving", "786", "Liam", 500, "11-11-2022");
        when(AccountDAO.addAccount(account)).thenReturn(account);
        ResponseEntity<Account> res = account_controller.addAccount(account);

        assertEquals(HttpStatus.CREATED, res.getStatusCode());
        assertEquals(account, res.getBody());

    }
}
