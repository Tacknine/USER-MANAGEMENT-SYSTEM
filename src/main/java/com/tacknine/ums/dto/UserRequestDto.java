package com.tacknine.ums.dto;

import com.tacknine.ums.entity.User;

public class UserRequestDto {

// vinavyotoka kwa user
    public Long id;
    private String  firstName;
    private String  lastName;
    private String  email;
    private String  password;
    private String  role;
    private Integer age;
    private Double  salary;


// default constructor
    public UserRequestDto() {}

    //parameterlized constructor

    public User toUser() {
        User user = new User();// object ya user
        user.setId(this.id);
        user.setLastName(this.lastName);
        user.setFirstName(this.firstName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setAge(this.age);
        user.setSalary(this.salary);
        return user;
    }


    //getter

    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Integer getAge() {
        return age;
    }
    public Double getSalary() {
        return salary;
    }
}


