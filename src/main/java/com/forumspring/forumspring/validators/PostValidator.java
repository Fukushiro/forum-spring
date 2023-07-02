package com.forumspring.forumspring.validators;

import com.forumspring.forumspring.dtos.PostDto;
import com.forumspring.forumspring.models.User;
import com.forumspring.forumspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostValidator {
    @Autowired
    private UserRepository userRepository;
    public boolean validatePostDto(PostDto postDto){
        Optional<User> user = userRepository.findById(postDto.getUser());
        if(!user.isPresent()){
            return false;
        }
        return true;
    }
}
