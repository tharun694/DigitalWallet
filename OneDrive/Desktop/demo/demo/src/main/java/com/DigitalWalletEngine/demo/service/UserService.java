package com.DigitalWalletEngine.demo.service;

import com.DigitalWalletEngine.demo.UserRepo;
import com.DigitalWalletEngine.demo.Entity.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    UserService service;
    UserRepo repo;
    UserService(UserRepo repo){
        this.repo=repo;
    }

    public User getuser(Long user_id) {
       return repo.findById(user_id).orElseThrow(()->new RuntimeException("user not found"));
    }
    public User adduser(User user) {
        repo.save(user);
        return user;
    }
}
