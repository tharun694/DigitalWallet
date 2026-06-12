package com.DigitalWalletEngine.demo.service;

import com.DigitalWalletEngine.demo.Configuration.RabbitConfig;
import com.DigitalWalletEngine.demo.Entity.Transaction;
import com.DigitalWalletEngine.demo.Entity.User;
import com.DigitalWalletEngine.demo.TransRepo;
import com.DigitalWalletEngine.demo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransService {
    TransRepo Tranrepo;
    UserRepo repo;
    RabbitTemplate template;
TransService(TransRepo rep, UserRepo repo,RabbitTemplate template){
   this.Tranrepo=rep;
   this.repo=repo;
    this.template=template;
}
@Transactional
    public Transaction trans(Long sId, Long rId,Transaction transaction) throws InterruptedException {

       User sender=repo.findByIdForUpdate(sId).orElseThrow(() -> new RuntimeException("user not found"));
        Thread.sleep(10000);
        User reciver = repo.findById(rId).orElseThrow(() -> new RuntimeException("user not found"));
        long transactionAmount=0;
        long l=0;
        if (sender.getDepositAmount() >= transaction.getAmount()&&sender.getId()!=reciver.getId()&&
        sender.getPin()==transaction.getSender().getPin()) {
             transactionAmount = reciver.getDepositAmount() + transaction.getAmount();
             l = sender.getDepositAmount() - transaction.getAmount();
            sender.setDepositAmount(l);
            reciver.setDepositAmount(transactionAmount);
            transaction.setDateTime(LocalDateTime.now());
            template.convertAndSend("audit.response",
                    "Transaction Success");
        }else{
            new RuntimeException("Invalid Transaction");
        }

       return Tranrepo.save(transaction);
    }
}
