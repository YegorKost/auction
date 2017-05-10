package com.yegor.service;

import com.yegor.model.CommentEntity;

import java.util.List;

/**
 * Created by YegorKost on 09.05.2017.
 */
public interface CommentService {
    CommentEntity addComment(CommentEntity comment);
    CommentEntity getComment(long id);
    List<CommentEntity> getAllComments();
    CommentEntity updateComment(CommentEntity comment);
    void deleteComment(CommentEntity comment);
}
