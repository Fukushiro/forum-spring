package com.forumspring.forumspring.controllers;

import com.forumspring.forumspring.dtos.UserDto;
import com.forumspring.forumspring.models.User;
import com.forumspring.forumspring.repositories.UserRepository;
import com.forumspring.forumspring.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto userDto){
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }

    @GetMapping ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }
}
