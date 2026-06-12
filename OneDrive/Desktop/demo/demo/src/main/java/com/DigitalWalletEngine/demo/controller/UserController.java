package com.DigitalWalletEngine.demo.controller;

import com.DigitalWalletEngine.demo.Entity.User;
import com.DigitalWalletEngine.demo.service.UserService;
import org.hibernate.dialect.LobMergeStrategy;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> adduser(@RequestBody User user){
        User users=service.adduser(user);
    return ResponseEntity.ok(users);
    }
    @GetMapping("/user/{user_id}")
    public User getuser(@PathVariable Long user_id){
       return service.getuser(user_id);
    }


}
