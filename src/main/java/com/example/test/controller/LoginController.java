package com.example.test.controller;


import com.example.test.dao.UserDao;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map){

        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功
            return "list";
        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

    @GetMapping(value = "/list")
    public String list(Model model){
        model.addAttribute("users",userDao.findAll());
        return "list";
    }

}
