package com.forumspring.forumspring.controllers;

import com.forumspring.forumspring.dtos.PostDto;
import com.forumspring.forumspring.models.Post;
import com.forumspring.forumspring.models.User;
import com.forumspring.forumspring.repositories.PostRepository;
import com.forumspring.forumspring.repositories.UserRepository;
import com.forumspring.forumspring.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity<Object> createPost(@RequestBody @Valid PostDto postDto) {
        Optional<User> user = userRepository.findById(postDto.getUser());
        System.out.println("Create post" + user.isPresent());
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario não existente");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postDto, user.get()));
    }

    @GetMapping
    public ResponseEntity<Page<Post>> getAllPosts(@PageableDefault(page = 0, size = 10, sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>  getPostById(@PathVariable("id") UUID id){
        Optional<Post> post = postRepository.findById(id);
        if(!post.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");        }
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }
}
