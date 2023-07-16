package com.forumspring.forumspring.repositories;

import com.forumspring.forumspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.username=?1")
    Optional<User> findUserByUsername(String username);
}
