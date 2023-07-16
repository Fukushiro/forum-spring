package com.forumspring.forumspring.dtos;

import jakarta.validation.constraints.NotNull;

public class UserReturnDto {
    @NotNull
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
