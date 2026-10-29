package com.DigitalWalletEngine.demo.Dto;

import com.DigitalWalletEngine.demo.Entity.User;
import com.DigitalWalletEngine.demo.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class ID {
    UserService service;
    public ID(UserService service){
        this.service=service;
    }
    @GetMapping("/allId")
    public List<Long> AllUserId(){
        return service.allUserId();
    }

}
