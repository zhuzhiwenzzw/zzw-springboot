package com.example.test.dao;

import com.example.test.moder.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository <User,Integer>{

    public User findUserByUsername(String username);

    public User findById(int id);
}
