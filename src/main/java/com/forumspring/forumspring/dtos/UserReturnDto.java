package com.forumspring.forumspring.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UserReturnDto {

    @NotNull
    private UUID id;
    @NotNull
    private String username;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
