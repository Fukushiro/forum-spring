package com.forumspring.forumspring.repositories;

import com.forumspring.forumspring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
