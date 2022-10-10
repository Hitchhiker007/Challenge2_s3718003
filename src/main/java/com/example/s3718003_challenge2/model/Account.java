package com.example.s3718003_challenge2.model;

import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {

    public Account() {

    }

    public Account(Integer id, String acctype, String accnumber, String accname, Integer balance,
                   Date date) {
        super();
        this.id = id;
        this.acctype = acctype;
        this.accnumber = accnumber;
        this.accname = accname;
        this.balance = balance;
        this.date = date;
    }

    private Integer id;
    private String acctype;
    private String accnumber;
    private String accname;
    private Integer balance;
    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccType() {
        return acctype;
    }

    public void setAccType(String acctype) {
        this.acctype = acctype;
    }

    public String getAccNumber() {
        return accnumber;
    }

    public void setAccNumber(String accnumber) {
        this.accnumber = accnumber;
    }

    public String getAccName() {
        return accname;
    }

    public void setAccName(String accname) {
        this.accname = accname;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", acctype=" + acctype + ", accnumber=" + accnumber + ", accname=" + accname +
                ", balance=" + balance + ", date=" + date + "]";
    }
}
//