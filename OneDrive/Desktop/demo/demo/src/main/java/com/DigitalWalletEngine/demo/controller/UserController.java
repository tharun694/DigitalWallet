package com.DigitalWalletEngine.demo.controller;

import com.DigitalWalletEngine.demo.Users;
import com.DigitalWalletEngine.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
    UserService service;
    UserController(UserService service){
        this.service=service;
    }

@GetMapping("/greet")
    public String message(){
        return "hello world";
    }
    @PostMapping("/adduser")
    public void adduser(@RequestBody Users user){
    service.adduser(user);
    }
    @GetMapping("/user/{user_id}")
    public Users getuser(@PathVariable Long user_id){
       return service.getuser(user_id);
    }
}
