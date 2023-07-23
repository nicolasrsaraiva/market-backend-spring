package com.study.marketbackend.service;

import com.study.marketbackend.entity.user.User;
import com.study.marketbackend.repository.UserRepository;
import com.study.marketbackend.service.dto.login.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(LoginDTO loginDTO){
        User user = userRepository.findByEmail(loginDTO.email());
        if(user != null && user.getPassword().equals(loginDTO.password())) {
            return user;
        }
        return null;
    }
}
