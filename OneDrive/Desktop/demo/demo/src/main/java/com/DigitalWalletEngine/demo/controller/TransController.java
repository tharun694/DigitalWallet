package com.DigitalWalletEngine.demo.controller;

import com.DigitalWalletEngine.demo.Entity.Transaction;
import com.DigitalWalletEngine.demo.Entity.User;
import com.DigitalWalletEngine.demo.service.TransService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TransController {
    TransService service;
    TransController(TransService service){
        this.service=service;
    }
    @PutMapping("/trans/{s_id}/{r_id}")
    public Transaction transactions(@PathVariable Long s_id,
                                    @PathVariable Long r_id,
                                    @RequestBody Transaction trans)throws InterruptedException{
return service.trans(s_id,r_id,trans);
    }
}
