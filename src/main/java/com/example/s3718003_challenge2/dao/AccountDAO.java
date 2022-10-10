package com.example.s3718003_challenge2.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.s3718003_challenge2.model.Account;
import com.example.s3718003_challenge2.exception.AddResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    static HashMap<Integer,Account> accountIDMap;

    public AccountDAO()
    {
        accountIDMap = new HashMap<Integer,Account>();

        Account jeffAccount = new Account(1, "Term Investment", "23456789", "Jeff",350, "10-10-2022");
        Account michaelAccount = new Account(2, "Loan", "9384849", "Michael", 19, "10-10-2022");
        Account lokeshAccount = new Account(3, "Saving", "9480450", "Lokesh", 450, "10-10-2022");

        accountIDMap.put(1,jeffAccount);
        accountIDMap.put(2,michaelAccount);
        accountIDMap.put(3,lokeshAccount);
    }

    public List getAllAccounts()
    {
        List accounts = new ArrayList(accountIDMap.values());
        return accounts;
    }

    public Account getAccountbyID(int id)
    {
        Account Account = accountIDMap.get(id);
        return Account;
    }

    public Account getAccountbyName(String accountName)
    {
        Account Account = null;
        for (int i:accountIDMap.keySet())
        {
            if(accountIDMap.get(i).getAccName().equals(accountName))
                Account = accountIDMap.get(i);
        }
        return Account;
    }

    public Account addAccount(Account Account)
    {
        Account.setId(getMaxId());
        accountIDMap.put(Account.getId(), Account);
        return Account;
    }

    public static int getMaxId()
    {
        int max=0;
        for (int id: accountIDMap.keySet())
            if(max<=id)
                max=id;
        return max+1;
    }

    public Account updateAccount(Account Account)
    {
        if(Account.getId()>0)
            accountIDMap.put(Account.getId(), Account);
        return Account;
    }

    public AddResponse deleteAccount(int id)
    {
        accountIDMap.remove(id);
        AddResponse res = new AddResponse();
        res.setMsg("Account has been deleted");
        res.setId(id);
        return res;
    }

}