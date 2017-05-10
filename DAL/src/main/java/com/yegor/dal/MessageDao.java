package com.yegor.dal;

import com.yegor.model.MessageEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface MessageDao {
    MessageEntity addMessage(MessageEntity message);
    MessageEntity getMessage(long id);
    List<MessageEntity> getAllMessages();
    MessageEntity updateMessage(MessageEntity message);
    void deleteMessage(MessageEntity message);
}
