package com.bridgelabz.userlogin.model;

import com.bridgelabz.userlogin.dto.UserDto;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "user_registration")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String address;  public boolean verified;
    

    public User(UserDto userDto) {
        this.firstName = userDto.firstName;
        this.lastName = userDto.lastName;
        this.email = userDto.email;
        this.password = userDto.password;
        this.address = userDto.address;
        this.verified=userDto.verified;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
    }



    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean getVerified() {
        return verified;
    }
}
