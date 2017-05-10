package com.yegor.service.serviceImpl;

import com.yegor.dal.CommentDao;
import com.yegor.model.CommentEntity;
import com.yegor.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 09.05.2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public CommentEntity addComment(CommentEntity comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public CommentEntity getComment(long id) {
        return commentDao.getComment(id);
    }

    @Override
    public List<CommentEntity> getAllComments() {
        return commentDao.getAllComments();
    }

    @Override
    public CommentEntity updateComment(CommentEntity comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public void deleteComment(CommentEntity comment) {
        commentDao.deleteComment(comment);
    }
}
