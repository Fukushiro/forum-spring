package com.forumspring.forumspring.services;

import com.forumspring.forumspring.dtos.UserDto;
import com.forumspring.forumspring.models.User;
import com.forumspring.forumspring.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        User retUser = userRepository.save(user);
        return retUser;
    }
}
