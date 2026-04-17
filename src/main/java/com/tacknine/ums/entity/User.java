package com.tacknine.ums.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Not;

import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // collumn za tables
    private Long id;
    @Column(nullable = false)
    private String  firstName;
    @Column(nullable = false)
    private String  lastName;
    @Column(unique=true)
    private String  email;
    @Column(nullable = false)
    private String  password;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private Double  salary;


    @ManyToOne(fetch = FetchType.EAGER)
    Set<Role> role;


    //getter na setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Double getSalary() {
        return salary;
    }
     public void setSalary(Double  salary) {
        this.salary = salary;
    }

}
