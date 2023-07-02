package com.forumspring.forumspring.services;

import com.forumspring.forumspring.dtos.PostDto;
import com.forumspring.forumspring.models.Post;
import com.forumspring.forumspring.models.User;
import com.forumspring.forumspring.repositories.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public Post createPost(PostDto postDto, User user) {
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        post.setUser(user);
        Post post2 = postRepository.save(post);
        System.out.println("AQUIIII:" +  post2.getText());
        return post2;
    }
}
