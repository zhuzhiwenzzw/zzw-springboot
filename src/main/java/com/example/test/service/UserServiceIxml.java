package com.example.test.service;

import com.example.test.dao.UserDao;
import com.example.test.moder.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIxml implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public String  findByusername(String username,String password) {

        User user = new User();
        user=userDao.findUserByUsername(username);
        System.out.println("service里面的通过姓名的查询：" + user);
        if(user !=null){
            if (user.getPassword().equals(password)){
                System.out.println("登录成功");
                return "redirect:/list";
            }
            System.out.println("密码错误");
            return "redirect:/login";
        }
        System.out.println("用户名不存在");
        return "redirect:/login";
    }
}
