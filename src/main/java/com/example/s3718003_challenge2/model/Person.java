package com.example.s3718003_challenge2.model;

public class Person {

    public Person() {

    }

    public Person(Integer id, String name, String address, Integer postcode, Integer age,
                  String job, String email, String phoneno) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.age = age;
        this.job = job;
        this.email = email;
        this.phoneno = phoneno;
    }

    private Integer id;
    private String name;
    private String address;
    private Integer postcode;
    private Integer age;
    private String job;
    private String email;
    private String phoneno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", address=" + address + ", postcode=" + postcode +
                ", age=" + age + ", job=" + job + ", email=" + email + ", phoneno=" + phoneno + "]";
    }
}
