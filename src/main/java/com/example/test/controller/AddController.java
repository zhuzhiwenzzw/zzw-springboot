package com.example.test.controller;

import com.example.test.dao.UserDao;
import com.example.test.moder.User;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/add")
    public String add(){
        //进入到添加页面
        return "add";
    }

    @PostMapping(value = "/add")
    public String add(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(2);

        userService.add(user);
        return "redirect:/list";
    }
}
