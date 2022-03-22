package com.bridgelabz.userlogin.service;

import com.bridgelabz.userlogin.dto.ForgotPWDDto;
import com.bridgelabz.userlogin.dto.LoginDto;
import com.bridgelabz.userlogin.dto.ResponseDto;
import com.bridgelabz.userlogin.dto.UserDto;
import com.bridgelabz.userlogin.model.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    public ResponseEntity<ResponseDto> createAccount(UserDto userDto);
    public ResponseEntity<ResponseDto> getAll();
    public User getById(String id);
    //public ResponseEntity<ResponseDto> login(LoginDto loginDto);
   public ResponseEntity<ResponseDto> forgotPwd(ForgotPWDDto forgotPWDDto);

    public ResponseEntity<ResponseDto> verify(String token);


    public ResponseEntity<ResponseDto> loginUser(LoginDto dto);
}
