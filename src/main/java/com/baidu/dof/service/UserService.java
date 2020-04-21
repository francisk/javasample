package com.baidu.dof.service;

import com.baidu.dof.entity.UserEntity;
import com.baidu.dof.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public UserEntity findUserByName(String name) {
        UserEntity user = null;
        try {
            user = userRepository.findByUserName(name);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public UserEntity findUserById(long id) {
        UserEntity user = null;
        try {
            user = userRepository.findUserById(id);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public UserEntity findUniqueUser(String name, String email) {
        UserEntity user = null;
        try{
            user = userRepository.findUniqueUser(name,email);
        } catch(Exception e){
            return null;
        }
        return user;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity save(UserEntity user) {
        return userRepository.saveAndFlush(user);
    }

    public void delete(UserEntity user) {
        userRepository.delete(user);
    }
}
