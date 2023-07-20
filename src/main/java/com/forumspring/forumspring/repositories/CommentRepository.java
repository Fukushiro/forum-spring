package com.forumspring.forumspring.repositories;

import com.forumspring.forumspring.models.Comment;
import com.forumspring.forumspring.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    @Query("SELECT c FROM Comment c WHERE c.post.id=?1 AND c.parentCommentary = null")
    public Page<Comment> findAllByPostId(UUID postId, Pageable pageable);

    @Query("SELECT c FROM Comment c WHERE c.parentCommentary != null AND c.parentCommentary.id =?1")
    public Page<Comment> findAllSubComments(UUID commentId, Pageable pageable);



}
