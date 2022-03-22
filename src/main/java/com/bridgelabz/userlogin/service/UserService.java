package com.bridgelabz.userlogin.service;

import com.bridgelabz.userlogin.Util.TokenUtil;
import com.bridgelabz.userlogin.dto.ForgotPWDDto;
import com.bridgelabz.userlogin.dto.LoginDto;
import com.bridgelabz.userlogin.dto.ResponseDto;
import com.bridgelabz.userlogin.dto.UserDto;
import com.bridgelabz.userlogin.model.Email;
import com.bridgelabz.userlogin.model.User;
import com.bridgelabz.userlogin.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class UserService implements IUserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
   TokenUtil tokenUtil;
    @Autowired
    IEmailService emailService;



    @Override
    public ResponseEntity<ResponseDto> createAccount(UserDto userDto) {

        User user= userRepo.save(new User(userDto));

        String token = tokenUtil.createToken(Long.valueOf(user.getId()));

        Email email = new Email(user.getEmail()," user is registered",user.getFirstName() + "=>" + emailService.getLink(token));
        emailService.sendMail(email);
        ResponseDto responseDto = new ResponseDto("User is created", user, token);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> getAll() {
        log.info(" we featching all user deatils");
        List<User> userList= userRepo.findAll();
        ResponseDto responseDto=new ResponseDto(" all user deatils",userList,null);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @Override
    public User getById(String id) {
        return userRepo.getById(id);
    }

    @Override
    public ResponseEntity<ResponseDto> forgotPwd(ForgotPWDDto forgotPWDDto) {
        Optional<User> user=userRepo.getUserByEmail(String.valueOf(forgotPWDDto.getEmail()));
            String body="http://localhost:4200/resetpassword/"+tokenUtil.createToken(Long.valueOf(user.get().getId()));
            Email email= new Email(user.get().getEmail(), "verification mail", user.get().getFirstName());
            return  emailService.sendMail(email);
    }




    @Override
    public ResponseEntity<ResponseDto> verify(String token) {
        Optional<User> user=userRepo.findById(Math.toIntExact(tokenUtil.decodeToken(token)));
        if (user.isEmpty()) {
            ResponseDto responseDTO = new ResponseDto("ERROR: Invalid token", null, token);
            return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.UNAUTHORIZED);
        }
        user.get().setVerified(true);
        userRepo.save(user.get());
        ResponseDto responseDTO = new ResponseDto(" The user has been verified ", user, token);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> loginUser(LoginDto dto){
       Optional<User> user=userRepo.findByEmail(dto.getEmail());
        boolean password=user.get().getPassword().equals(dto.getPassword());
        if(password=false){
                ResponseDto responseDto=new ResponseDto("login failed",null,null);
                return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.UNAUTHORIZED);
        }
        else{
             ResponseDto responseDto=new ResponseDto(" LOgin Sucessfully",user,null);
             return new ResponseEntity<>(responseDto,HttpStatus.OK);
        }

    }


}
