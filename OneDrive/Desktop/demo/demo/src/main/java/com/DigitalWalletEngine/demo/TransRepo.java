package com.DigitalWalletEngine.demo;

import com.DigitalWalletEngine.demo.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransRepo extends JpaRepository<Transaction,Long> {

}
