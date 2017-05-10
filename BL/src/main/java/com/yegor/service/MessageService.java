package com.yegor.service;

import com.yegor.model.MessageEntity;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
public interface MessageService {
    MessageEntity addMessage(MessageEntity message);
    MessageEntity getMessage(long id);
    List<MessageEntity> getAllMessages();
    MessageEntity updateMessage(MessageEntity message);
    void deleteMessage(MessageEntity message);
}
