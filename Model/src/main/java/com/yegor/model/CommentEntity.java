package com.yegor.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YegorKost on 26.04.2017.
 */
@Entity
@Table(name = "comments")
@NamedQuery(name = "getAllComments", query = "SELECT c FROM CommentEntity c")
public class CommentEntity {
    private long id;
    private String comment;
    private Timestamp commentDate;
    private UserEntity author;
    private MessageEntity message;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment", nullable = false)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "comment_date", nullable = false)
    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp comment_date) {
        this.commentDate = comment_date;
    }

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    public MessageEntity getMessage() {
        return message;
    }

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (!comment.equals(that.comment)) return false;
        return commentDate.equals(that.commentDate);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + comment.hashCode();
        result = 31 * result + commentDate.hashCode();
        return result;
    }
}
