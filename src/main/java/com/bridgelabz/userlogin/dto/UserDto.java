package com.bridgelabz.userlogin.dto;

public class UserDto {

    public String firstName ;
    public String lastName;
    public String email;
    public String password;
    public String address;
    public boolean verified;

    public UserDto(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.verified=false;
    }
}
