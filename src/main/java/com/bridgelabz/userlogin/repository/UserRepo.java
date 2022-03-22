package com.bridgelabz.userlogin.repository;

import com.bridgelabz.userlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

    public interface UserRepo extends JpaRepository<User,Integer> {


        @Query(value = "select * from user_registration where email=?1 password = ?2", nativeQuery = true)
        Long findByPassword(String email, String password);

        //Optional<User> findByEmail(String email);

        // @Query(value = "select * from user where email=?1",nativeQuery = true)
        // Optional<User> getUserByEmail(String email);

        @Query(value = " select  * from user_registrationhere id=?1", nativeQuery = true)
        User getById(String id);

        Optional<User> findByEmail(String email);
        Optional<User> getUserByEmail(String email);


    }



