package com.bridgelabz.userlogin.dto;

import com.bridgelabz.userlogin.model.User;
import org.springframework.http.HttpStatus;

public class ResponseDto {

    public String message;
    public Object object;
    public String token;

    public ResponseDto(String message, Object object, String token) {
        this.message = message;
        this.object = object;
        this.token = token;
    }


}
