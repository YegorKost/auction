package com.yegor.service.serviceImpl;

import com.yegor.dal.MessageDao;
import com.yegor.model.MessageEntity;
import com.yegor.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public MessageEntity addMessage(MessageEntity message) {
        return messageDao.addMessage(message);
    }

    @Override
    public MessageEntity getMessage(long id) {
        return messageDao.getMessage(id);
    }

    @Override
    public List<MessageEntity> getAllMessages() {
        return messageDao.getAllMessages();
    }

    @Override
    public MessageEntity updateMessage(MessageEntity message) {
        return messageDao.updateMessage(message);
    }

    @Override
    public void deleteMessage(MessageEntity message) {
        messageDao.deleteMessage(message);
    }
}
