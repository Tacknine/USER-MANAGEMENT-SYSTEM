package com.tacknine.ums.dto;
import com.tacknine.ums.entity.User;
public class UserResponseDto {


    // kinachorudi kwa user

    private Long id;
    private String  lastName;
    private String  firstName;
    private String  email;
    private Integer age;
    private Double salary;


    //default constructor

    public UserResponseDto() {
    }


    //parameterized constructor

   public UserResponseDto(User user) {

         // haina object
       this.setId(user.getId());
       this.setLastName(user.getLastName());
       this.setFirstName(user.getFirstName());
       this.setAge(user.getAge());
       this.setEmail(user.getEmail());
       this.setSalary(user.getSalary());

   }


   //setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
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

    public void setSalary(Double salary) {
        this.salary = salary;
    }


}
