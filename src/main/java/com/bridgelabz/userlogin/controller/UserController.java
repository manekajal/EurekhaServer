package com.bridgelabz.userlogin.controller;


import com.bridgelabz.userlogin.dto.ForgotPWDDto;
import com.bridgelabz.userlogin.dto.LoginDto;
import com.bridgelabz.userlogin.dto.ResponseDto;
import com.bridgelabz.userlogin.dto.UserDto;
import com.bridgelabz.userlogin.model.User;
import com.bridgelabz.userlogin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> getAll(){
        return iUserService.getAll();
   }

   @PostMapping("/register")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody UserDto userDto){
     return iUserService.createAccount(userDto);
    }

   @GetMapping("/getById/{id}")
    public User getById(@PathVariable String id){
        return iUserService.getById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginDto loginDto){
       return iUserService.loginUser(loginDto);

  }

    @PostMapping("/forgot")
   public ResponseEntity<ResponseDto> forgotPwd( @RequestBody ForgotPWDDto forgotPWDDto){
       return iUserService.forgotPwd(forgotPWDDto);
   }
   @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDto> verifyUser(@PathVariable String token) {
       return iUserService.verify(token);
    }

}
