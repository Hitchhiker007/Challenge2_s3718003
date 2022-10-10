package com.example.s3718003_challenge2.controller;
import com.example.s3718003_challenge2.dao.AccountDAO;
import com.example.s3718003_challenge2.exception.AddResponse;
import com.example.s3718003_challenge2.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class account_controller {

    @Autowired
    AccountDAO AccountDAO;


    @GetMapping()
    public List getAllPersons()
    {
        return AccountDAO.getAllAccounts();
    }

    @GetMapping("account/{id}")
    public Account getAccountID(@PathVariable(value="id") int id)
    {
        return AccountDAO.getAccountbyID(id);
    }

    @GetMapping("accountaccountName")
    public Account getAccountbyname(@PathVariable(value="name") String accountName)
    {
        return AccountDAO.getAccountbyName(accountName);
    }

    @PostMapping()
    public Account addPerson(@RequestBody Account Account)
    {
        return AccountDAO.addAccount(Account);
    }

    @PutMapping()
    public Account updateAccount(@RequestBody Account Account)
    {
        return AccountDAO.updateAccount(Account);
    }

    @DeleteMapping("/deleteaccount/{id}")
    public AddResponse deleteAccount(@PathVariable(value = "id")int id)
    {
        return AccountDAO.deleteAccount(id);
    }
}

