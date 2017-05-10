package com.yegor.dal.daoImpl;

import com.yegor.dal.MessageDao;
import com.yegor.model.MessageEntity;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by YegorKost on 02.05.2017.
 */
@Transactional
@Repository
public class MessageDaoImpl implements MessageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        LOGGER.info("------- Getting SessionFactory {} ", sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public MessageEntity addMessage(MessageEntity messageEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(messageEntity);
        LOGGER.info("Adding the message with id {}", id);
        return messageEntity;
    }

    @Override
    public MessageEntity getMessage(long id) {
        MessageEntity messageEntity = sessionFactory
                .getCurrentSession()
                .get(MessageEntity.class, id);
        LOGGER.info("Getting the message with id - {}", messageEntity.getId());
        return messageEntity;
    }

    @Override
    public List<MessageEntity> getAllMessages() {
        List<MessageEntity> allMessages = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllMessages", MessageEntity.class)
                .getResultList();
        LOGGER.info("Getting all messages");
        return allMessages;
    }

    @Override
    public MessageEntity updateMessage(MessageEntity messageEntity) {
        sessionFactory
                .getCurrentSession()
                .update(messageEntity);
        LOGGER.info("Updating the message with id - {}", messageEntity.getId());
        return messageEntity;
    }

    @Override
    public void deleteMessage(MessageEntity messageEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(messageEntity);
        LOGGER.info("Deleting the message with id - {}", messageEntity.getId());
    }
}
