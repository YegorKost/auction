package com.yegor.dal.daoImpl;

import com.yegor.dal.MessageDao;
import com.yegor.model.MessageEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 02.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDaoImplTest extends DalTest{
    @Test
    public void addMessageTest() throws Exception {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage("newMessage");
        messageEntity.setMessageDate(Timestamp.valueOf("2017-07-30 11:15:06"));
        messageEntity.setAuthor(user1);
        messageEntity.setLot(lot2);
        messageDao.addMessage(messageEntity);
        assertEquals(messageEntity, messageDao.getMessage(messageEntity.getId()));
    }

    @Test
    public void getMessageTest() throws Exception {
        assertEquals(message1, messageDao.getMessage(message1.getId()));
        assertEquals(message2, messageDao.getMessage(message2.getId()));
    }

    @Test
    public void getAllMessagesTest() throws Exception {
        List<MessageEntity> allMessages = messageDao.getAllMessages();
        assertEquals(2, allMessages.size());
        assertTrue(allMessages.contains(message1));
        assertTrue(allMessages.contains(message2));
    }

    @Test
    public void updateMessageTest() throws Exception {
        MessageEntity message = messageDao.getMessage(message1.getId());
        message.setMessage("updated");
        messageDao.updateMessage(message);
        assertEquals("updated", messageDao.getMessage(message1.getId()).getMessage());
    }

    @Test
    public void deleteMessageTest() throws Exception {
        List<MessageEntity> allMessages = messageDao.getAllMessages();
        assertEquals(2, allMessages.size());
        assertTrue(allMessages.contains(message2));
        messageDao.deleteMessage(message2);
        allMessages = messageDao.getAllMessages();
        assertEquals(1, allMessages.size());
        assertFalse(allMessages.contains(message2));
    }

    @Test(expected = Exception.class)
    public void deleteMessageTest1() throws Exception {
        messageDao.deleteMessage(message1);
    }

}