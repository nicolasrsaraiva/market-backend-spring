package com.study.marketbackend.service.dto.user;

import com.study.marketbackend.entity.user.User;

public record ReadUserDTO(String firstName, String lastName, String email)
{
    public ReadUserDTO(User user){
        this(user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
