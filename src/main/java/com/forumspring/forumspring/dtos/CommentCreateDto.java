package com.forumspring.forumspring.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CommentCreateDto {

    @NotNull
    @NotEmpty
    private String text;

    @NotNull
    private UUID userId;

    @NotNull
    private UUID postId;

    private UUID parentComment;

    public UUID getParentComment() {
        return parentComment;
    }

    public void setParentComment(UUID parentComment) {
        this.parentComment = parentComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }
}
