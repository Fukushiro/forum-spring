package com.forumspring.forumspring.controllers;

import com.forumspring.forumspring.dtos.UserDto;
import com.forumspring.forumspring.dtos.UserReturnDto;
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
import java.util.Objects;

@RestController
@RequestMapping("/users")
//@CrossOrigin(allowedHeaders = "*")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto userDto){
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<Object> authUser(@RequestBody @Valid UserDto userDto){
        System.out.println("#AUTH");
        UserReturnDto user = userService.authUser(userDto);
        if(Objects.isNull(user)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }
}
