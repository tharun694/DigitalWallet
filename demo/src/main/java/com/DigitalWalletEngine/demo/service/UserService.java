package com.DigitalWalletEngine.demo.service;

import com.DigitalWalletEngine.demo.UserRepo;
import com.DigitalWalletEngine.demo.Entity.User;
import org.apache.el.stream.Stream;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    public List<Long> allUserId() {
        List<User> list=new ArrayList<>();
        List<Long> allUserId=new ArrayList<>();

        list.addAll(repo.findAll());
        for (int i = 0; i < list.size(); i++) {
            allUserId.add(list.get(i).getId());
        }
      return allUserId;
    }
}
