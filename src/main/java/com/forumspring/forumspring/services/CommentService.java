package com.forumspring.forumspring.services;

import com.forumspring.forumspring.dtos.CommentCreateDto;
import com.forumspring.forumspring.dtos.PostDto;
import com.forumspring.forumspring.models.Comment;
import com.forumspring.forumspring.models.Post;
import com.forumspring.forumspring.models.User;
import com.forumspring.forumspring.repositories.CommentRepository;
import com.forumspring.forumspring.repositories.PostRepository;
import com.forumspring.forumspring.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
  public Comment createComment (CommentCreateDto commentCreateDto) {
      Comment comment = new Comment();
      BeanUtils.copyProperties(commentCreateDto, comment);
      Optional<User> user = userRepository.findById(commentCreateDto.getUserId());
      if(user.isPresent()){
          Optional<Post> post = postRepository.findById(commentCreateDto.getPostId());
          if(post.isPresent()){
              comment.setUser(user.get());
              comment.setPost(post.get());
              comment.setCreateDate(new Date());
              if(Objects.nonNull(commentCreateDto.getParentComment())){
                  Optional<Comment> parentComment =  commentRepository.findById(commentCreateDto.getParentComment());
                  if(parentComment.isPresent()){
                    comment.setParentCommentary(parentComment.get());
                  }
              }
              comment = commentRepository.save(comment);
              return comment;
          }
      }
      return null;

  }
}
