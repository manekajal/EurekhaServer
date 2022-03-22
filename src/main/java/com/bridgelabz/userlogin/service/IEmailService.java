package com.bridgelabz.userlogin.service;

import com.bridgelabz.userlogin.dto.ResponseDto;
import com.bridgelabz.userlogin.model.Email;
import org.springframework.http.ResponseEntity;

public interface IEmailService {

    public ResponseEntity<ResponseDto> sendMail(Email email);

    public String getLink(String token);
}
