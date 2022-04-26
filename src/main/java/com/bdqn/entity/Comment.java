package com.bdqn.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论表(Comment)实体类
 *
 * @author makejava
 * @since 2022-04-23 15:59:35
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 672365832363607859L;
    
    private Long commentId;
    
    private Long userId;
    
    private String commentContent;
    
    private Long movieId;
    
    private Date commentTime;
    
    private Integer commentScore;

    private User comment_user; //所属用户

    public User getComment_user() {
        return comment_user;
    }

    public void setComment_user(User comment_user) {
        this.comment_user = comment_user;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }

}

