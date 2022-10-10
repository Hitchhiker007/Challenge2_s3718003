package com.example.s3718003_challenge2.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.s3718003_challenge2.model.Account;
import com.example.s3718003_challenge2.exception.AddResponse;
import com.example.s3718003_challenge2.model.Person;
import com.example.s3718003_challenge2.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    @Autowired
    AccountRepository accountrep;

    public List<Account> getAllAccounts()
    {
        return accountrep.findAll();
    }

    public Account getAccountbyID(int id)
    {
        return accountrep.findById(id).get();
    }

    public Account getAccountbyName(String accountName)
    {
        List<Account> accounts=accountrep.findAll();
        Account account = null;
        for(Account acc:accounts)
        {
            if(acc.getAccName().equalsIgnoreCase(accountName))
                account=acc;
        }
        return account;
    }

    public Account addAccount(Account account)
    {
        account.setId(getMaxId());
        accountrep.save(account);
        return account;
    }

    public int getMaxId()
    {
        return accountrep.findAll().size()+1;
    }

    public Account updateAccount(Account account)
    {
        accountrep.save(account);
        return account;
    }

    public AddResponse deleteAccount(int id)
    {
        accountrep.deleteById(id);
        AddResponse res= new AddResponse();
        res.setMsg("Account Deleted !");
        res.setId(id);
        return res;
    }


}