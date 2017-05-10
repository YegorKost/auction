package com.yegor.dal.daoImpl;

import com.yegor.dal.CommentDao;
import com.yegor.model.CommentEntity;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by YegorKost on 01.05.2017.
 */
@Transactional
@Repository
public class CommentDaoImpl implements CommentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        LOGGER.info("------- Getting SessionFactory {} ", sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CommentEntity addComment(CommentEntity commentEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(commentEntity);
        LOGGER.info("Adding the comment with id - {}", id);
        return commentEntity;
    }

    @Override
    public CommentEntity getComment(long id) {
        CommentEntity commentEntity = sessionFactory
                .getCurrentSession()
                .get(CommentEntity.class, id);
        LOGGER.info("Getting the comment with id - {}", commentEntity.getId());
        return commentEntity;
    }

    @Override
    public List<CommentEntity> getAllComments() {
        List<CommentEntity> getAllComments = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllComments", CommentEntity.class)
                .getResultList();
        LOGGER.info("Getting all comments");
        return getAllComments;
    }

    @Override
    public CommentEntity updateComment(CommentEntity commentEntity) {
        sessionFactory
                .getCurrentSession()
                .update(commentEntity);
        LOGGER.info("Updating the comment with id - {}", commentEntity.getId());
        return commentEntity;
    }

    @Override
    public void deleteComment(CommentEntity commentEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(commentEntity);
        LOGGER.info("Deleting the comment with id - {} successful", commentEntity.getId());
    }
}
