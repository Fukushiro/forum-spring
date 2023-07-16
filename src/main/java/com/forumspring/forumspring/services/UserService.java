package com.forumspring.forumspring.services;

import com.forumspring.forumspring.dtos.UserDto;
import com.forumspring.forumspring.dtos.UserReturnDto;
import com.forumspring.forumspring.models.User;
import com.forumspring.forumspring.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserReturnDto createUser(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user = userRepository.save(user);
        UserReturnDto userReturnDto = new UserReturnDto();
        BeanUtils.copyProperties(user, userReturnDto);
        return userReturnDto;
    }

    public UserReturnDto authUser(UserDto userDto){
        Optional<User> user = userRepository.findUserByUsername(userDto.getUsername());
        if(!user.isPresent()){
            return null;
        }
        if(!passwordEncoder.matches(userDto.getPassword(), user.get().getPassword())){
            return null;
        }
        UserReturnDto userReturnDto = new UserReturnDto();
        BeanUtils.copyProperties(user.get(), userReturnDto);
        return userReturnDto;
    }
}
