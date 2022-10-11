package com.example.s3718003_challenge2.controller;
import com.example.s3718003_challenge2.dao.AccountDAO;
import com.example.s3718003_challenge2.exception.AddResponse;
import com.example.s3718003_challenge2.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class account_controller {

    @Autowired
    AccountDAO AccountDAO;


    @GetMapping()
    public List<Account> getAllAccounts()
    {
        return AccountDAO.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountbyID(@PathVariable(value="id") int id)
    {
        try
        {
            Account account  = AccountDAO.getAccountbyID(id);
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/accountName")
    public ResponseEntity<Account> getAccountbyname(@PathVariable(value="name") String accountName)
    {
        try
        {
            Account account  = AccountDAO.getAccountbyName(accountName);
            return new ResponseEntity<Account>(account,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addaccount")
    public Account addAccount(@RequestBody Account account)
    {
        return AccountDAO.addAccount(account);
    }

    @PutMapping("/updateaccount")
    public ResponseEntity<Account> updateAccount(@PathVariable(value="id") int id, @RequestBody Account account)
    {
        try {
            Account existAccount = AccountDAO.getAccountbyID(id);
            existAccount.setAccType(account.getAccType());
            existAccount.setAccNumber(account.getAccNumber());
            existAccount.setAccName(account.getAccName());
            existAccount.setBalance(account.getBalance());
            existAccount.setDate(account.getDate());

            Account updated_account = AccountDAO.updateAccount(existAccount);
            return new ResponseEntity<Account>(updated_account,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteaccount/{id}")
    public AddResponse deleteAccount(@PathVariable(value = "id")int id)
    {
        return AccountDAO.deleteAccount(id);
    }
}

