package com.bridgelabz.userlogin.dto;

import lombok.Data;

@Data
public class ForgotPWDDto {


    public String email;

    public ForgotPWDDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
