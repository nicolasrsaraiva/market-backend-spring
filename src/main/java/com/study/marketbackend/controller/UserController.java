package com.study.marketbackend.controller;

import com.study.marketbackend.entity.user.User;
import com.study.marketbackend.repository.UserRepository;
import com.study.marketbackend.service.dto.user.CreateUserDTO;
import com.study.marketbackend.service.dto.user.ReadUserDTO;
import com.study.marketbackend.service.dto.user.UpdateUserDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @Transactional
    public List<ReadUserDTO> readUsers(){
        return userRepository.findAll().stream().map(ReadUserDTO::new).collect(Collectors.toList()); //change method (select password in query)
    }

    @GetMapping("/{id}")
    public ReadUserDTO readUser(@PathVariable Long id){
        var user = userRepository.getReferenceById(id);
        return new ReadUserDTO(user);
    }

    @PostMapping
    @Transactional
    public void createUser(@RequestBody @Valid CreateUserDTO createUserDTO){
        userRepository.save(new User(createUserDTO));
    }

    @PutMapping
    @Transactional
    public void updateUser(@RequestBody @Valid UpdateUserDTO updateUserDTO){
        var user = userRepository.getReferenceById(updateUserDTO.id());
        user.updateUser(updateUserDTO);
    }
}