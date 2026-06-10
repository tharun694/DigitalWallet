package com.DigitalWalletEngine.demo.service;

import com.DigitalWalletEngine.demo.UserRepo;
import com.DigitalWalletEngine.demo.Users;
import com.DigitalWalletEngine.demo.controller.UserController;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    UserService service;
    UserRepo repo;
    UserService(UserRepo repo){
        this.repo=repo;
    }

    public Users getuser(Long user_id) {
       return repo.findById(user_id).orElseThrow(()->new RuntimeException("user not found"));
    }
    public void adduser(Users user) {
        repo.save(user);
    }
}
