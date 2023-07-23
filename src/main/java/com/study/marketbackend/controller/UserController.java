package com.study.marketbackend.controller;

import com.study.marketbackend.entity.user.User;
import com.study.marketbackend.repository.UserRepository;
import com.study.marketbackend.service.dto.user.CreateUserDTO;
import com.study.marketbackend.service.dto.user.ReadUserDTO;
import com.study.marketbackend.service.dto.user.UpdateUserDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ReadUserDTO>> readUsers(){
        var response = userRepository.findAll().stream().map(ReadUserDTO::new).collect(Collectors.toList()); //change method (select password in query)
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadUserDTO> readUser(@PathVariable Long id){
        var response = new ReadUserDTO(userRepository.getReferenceById(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createUser(@RequestBody @Valid CreateUserDTO createUserDTO){
        userRepository.save(new User(createUserDTO));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UpdateUserDTO updateUserDTO){
        var user = userRepository.getReferenceById(updateUserDTO.id());
        user.updateUser(updateUserDTO);
        return ResponseEntity.ok().build();
    }
}