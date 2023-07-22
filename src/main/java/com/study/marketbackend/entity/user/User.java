package com.study.marketbackend.entity.user;

import com.study.marketbackend.service.dto.user.CreateUserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "User")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(CreateUserDTO createUserDTO) {
        this.firstName = createUserDTO.firstName();
        this.lastName = createUserDTO.lastName();
        this.email = createUserDTO.email();
        this.password = createUserDTO.password();
    }
}


