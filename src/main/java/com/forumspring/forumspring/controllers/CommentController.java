package com.forumspring.forumspring.controllers;

import com.forumspring.forumspring.dtos.CommentCreateDto;
import com.forumspring.forumspring.dtos.UserDto;
import com.forumspring.forumspring.dtos.UserReturnDto;
import com.forumspring.forumspring.models.Comment;
import com.forumspring.forumspring.models.Post;
import com.forumspring.forumspring.models.User;
import com.forumspring.forumspring.repositories.CommentRepository;
import com.forumspring.forumspring.repositories.UserRepository;
import com.forumspring.forumspring.services.CommentService;
import com.forumspring.forumspring.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
@CrossOrigin(allowedHeaders = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;
    @PostMapping
    public ResponseEntity<Object> createComment (@RequestBody @Valid CommentCreateDto commentCreateDto) {
        return ResponseEntity.ok().body(commentService.createComment(commentCreateDto));
    }

    @GetMapping
    public ResponseEntity<Page<Comment>> getAllComments(@PageableDefault(page = 0, size = 10, sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(commentRepository.findAll(pageable));
    }

    @GetMapping("/post/{idPost}")
    public ResponseEntity<Page<Comment>> getPostComments(
            @PageableDefault(page = 0, size = 10, sort = "createDate", direction = Sort.Direction.ASC) Pageable pageable,
            @PathVariable("idPost") UUID idPost
            ){
        return ResponseEntity.status(HttpStatus.OK).body(commentRepository.findAllByPostId(idPost, pageable));

    }

    @GetMapping("/subcomments/{idComment}")
    public ResponseEntity<Page<Comment>> getSubComments  (
            @PageableDefault(page = 0, size = 10, sort = "createDate", direction = Sort.Direction.ASC) Pageable pageable,
            @PathVariable("idComment") UUID idComment
    ){
        return ResponseEntity.status(HttpStatus.OK).body(commentRepository.findAllSubComments(idComment, pageable));
    }


}
