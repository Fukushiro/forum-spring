package com.forumspring.forumspring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonManagedReference
    private Post post;

    @Column(name = "createDate", nullable = false)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "parentCommentary", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Comment> childCommentaries;

    @ManyToOne
    @JoinColumn(name = "parent_commentary_id")
    @JsonManagedReference
    private Comment parentCommentary;


    public List<Comment> getChildCommentaries() {
        return childCommentaries;
    }

    public void setChildCommentaries(List<Comment> childCommentaries) {
        this.childCommentaries = childCommentaries;
    }

    public Comment getParentCommentary() {
        return parentCommentary;
    }

    public void setParentCommentary(Comment parentCommentary) {
        this.parentCommentary = parentCommentary;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
