package com.yegor.dal.daoImpl;

import com.yegor.model.CommentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 01.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentDaoImplTest extends DalTest{

    @Test
    public void addCommentTest() throws Exception {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setMessage(message2);
        commentEntity.setComment("newComment");
        commentEntity.setCommentDate(Timestamp.valueOf("2017-07-26 17:17:03"));
        commentEntity.setAuthor(user2);
        commentDao.addComment(commentEntity);
        assertEquals(commentEntity, commentDao.getComment(commentEntity.getId()));
    }

    @Test
    public void getCommentTest() throws Exception {
        assertEquals(comment1, commentDao.getComment(comment1.getId()));
        assertEquals(comment2, commentDao.getComment(comment2.getId()));
    }

    @Test
    public void getAllCommentsTest() throws Exception {
        List<CommentEntity> allComments = commentDao.getAllComments();
        assertEquals(2, allComments.size());
        assertTrue(allComments.contains(comment1));
        assertTrue(allComments.contains(comment2));
    }

    @Test
    public void updateCommentTest() throws Exception {
        CommentEntity comment = commentDao.getComment(comment1.getId());
        comment.setComment("updated");
        commentDao.updateComment(comment);
        assertEquals("updated", commentDao.getComment(comment1.getId()).getComment());
    }

    @Test
    public void deleteCommentTest() throws Exception {
        List<CommentEntity> allComments = commentDao.getAllComments();
        assertEquals(2, allComments.size());
        assertTrue(allComments.contains(comment2));
        commentDao.deleteComment(comment2);
        allComments = commentDao.getAllComments();
        assertEquals(1, allComments.size());
        assertFalse(allComments.contains(comment2));
    }

}