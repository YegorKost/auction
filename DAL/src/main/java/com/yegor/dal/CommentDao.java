package com.yegor.dal;

import com.yegor.model.CommentEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface CommentDao {
    CommentEntity addComment(CommentEntity comment);
    CommentEntity getComment(long id);
    List<CommentEntity> getAllComments();
    CommentEntity updateComment(CommentEntity comment);
    void deleteComment(CommentEntity comment);
}
