package com.DigitalWalletEngine.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long amount;
    LocalDateTime dateTime;
   @ManyToOne
           //sender id
    User sender;

   @ManyToOne
           //reciver id
    User reciver;
}
