package com.example.test.service;

import com.example.test.moder.User;

public interface UserService {

    public void add(User user);

    public String findByusername(String username,String password);
}
