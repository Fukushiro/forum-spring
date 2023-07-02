package com.forumspring.forumspring.repositories;

import com.forumspring.forumspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
