package com.example.s3718003_challenge2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {

    //
    public Account() {

    }

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="acctype")
    private String acctype;
    @Column(name="accnumber")
    private String accnumber;
    @Column(name="accname")
    private String accname;
    @Column(name="balance")
    private Integer balance;
    @Column(name="date")
    private String date;

    public Account(Integer id, String acctype, String accnumber, String accname, Integer balance,
                   String date) {
        super();
        this.id = id;
        this.acctype = acctype;
        this.accnumber = accnumber;
        this.accname = accname;
        this.balance = balance;
        this.date = date;

    }


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", acctype=" + acctype + ", accnumber=" + accnumber + ", accname=" + accname +
                ", balance=" + balance + ", date=" + date + "]";
    }
}
//