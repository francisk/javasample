package com.baidu.dof.controller;

import com.baidu.dof.entity.UserEntity;
import com.baidu.dof.entity.AbstractEntity;
import com.baidu.dof.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import com.baidu.dof.util.ResponseObj;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObj allUser() {
        final List<UserEntity> allUser = userService.findAll();
        final List<AbstractEntity> entities = new ArrayList<>();
        for (final UserEntity user : allUser) {
            entities.add(user);
        }
        ResponseObj responseObj =new ResponseObj(entities);
        return responseObj;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity show(@RequestParam(value = "name") final String name) {
        final UserEntity user = userService.findUserByName(name);
        return user;
    }
    @RequestMapping(value="/add", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity add(@RequestParam(value = "name") final String name, 
    @RequestParam(value="password") final String password,
    @RequestParam(value="email")final String email )throws Exception{
        final UserEntity currentUser = userService.findUniqueUser(name,email);
        if (null == currentUser){
            UserEntity newUser =  new UserEntity();
            newUser.setName(name);
            newUser.setPassword(password);
            newUser.setEmail(email);
            Date current_time = Calendar.getInstance().getTime();
            newUser.setRegisterTime(current_time);
            UserEntity insertUser = userService.save(newUser);
            return insertUser;
        }else {
            return currentUser;
        }

    }

}
