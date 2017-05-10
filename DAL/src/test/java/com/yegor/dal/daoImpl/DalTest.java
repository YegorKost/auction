package com.yegor.dal.daoImpl;

import com.yegor.dal.*;
import com.yegor.dal.config.DataAccessLayerConfiguration;
import com.yegor.model.*;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by YegorKost on 01.05.2017.
 */
@ContextConfiguration(classes = DataAccessLayerConfiguration.class)
@Sql(scripts = "/delete_insert_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class DalTest {

    @Autowired
    protected RoleDao roleDao;

    @Autowired
    protected CategoryDao categoryDao;

    @Autowired
    protected OrderStatusDao orderStatusDao;

    @Autowired
    protected LotStatusDao lotStatusDao;

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected LotDao lotDao;

    @Autowired
    protected ImageDao imageDao;

    @Autowired
    protected OrderDao orderDao;

    @Autowired
    protected MessageDao messageDao;

    @Autowired
    protected CommentDao commentDao;

    static RoleEntity role1, role2, role3;
    static CategoryEntity category1, category2, category3;
    static OrderStatusEntity orderStatus1, orderStatus2, orderStatus3;
    static LotStatusEntity lotStatus1, lotStatus2, lotStatus3;
    static UserEntity user1, user2;
    static LotEntity lot1, lot2;
    static ImageEntity image1, image2, image3;
    static OrderEntity order1, order2;
    static MessageEntity message1, message2;
    static CommentEntity comment1, comment2;


    @BeforeClass
    public static void setUp() {
        role1 = new RoleEntity();
        role1.setId(1);
        role1.setRole("admin");

        role2 = new RoleEntity();
        role2.setId(2);
        role2.setRole("user");

        role3 = new RoleEntity();
        role3.setId(3);
        role3.setRole("user1");

        category1 = new CategoryEntity();
        category1.setId(1);
        category1.setCategory("Cars");

        category2 = new CategoryEntity();
        category2.setId(2);
        category2.setCategory("Art");

        category3 = new CategoryEntity();
        category3.setId(3);
        category3.setCategory("Antiques");

        orderStatus1 = new OrderStatusEntity();
        orderStatus1.setId(1);
        orderStatus1.setStatus("transient");

        orderStatus2 = new OrderStatusEntity();
        orderStatus2.setId(2);
        orderStatus2.setStatus("accept");

        orderStatus3 = new OrderStatusEntity();
        orderStatus3.setId(3);
        orderStatus3.setStatus("deny");

        lotStatus1 = new LotStatusEntity();
        lotStatus1.setId(1);
        lotStatus1.setStatus("await");

        lotStatus2 = new LotStatusEntity();
        lotStatus2.setId(2);
        lotStatus2.setStatus("open");

        lotStatus3 = new LotStatusEntity();
        lotStatus3.setId(3);
        lotStatus3.setStatus("close");

        user1 = new UserEntity();
        user1.setId(1);
        user1.setEmail("e1@mail.com");
        user1.setFirstName("first1");
        user1.setLastName("last1");
        user1.setLogin("login1");
        user1.setPassword("password1");
        user1.setPhoneNumber("1111111111");
        user1.setRole(role1);

        user2 = new UserEntity();
        user2.setId(2);
        user2.setEmail("e2@mail.com");
        user2.setFirstName("first2");
        user2.setLastName("last2");
        user2.setLogin("login2");
        user2.setPassword("password2");
        user2.setPhoneNumber("2222222222");
        user2.setRole(role2);

        lot1 = new LotEntity();
        lot1.setId(1);
        lot1.setName("name1");
        lot1.setDescription("description1");
        lot1.setStartPrice(BigInteger.valueOf(100));
        lot1.setCategory(category1);
        lot1.setLotDate(Timestamp.valueOf("2017-07-21 04:05:06"));
        lot1.setStartDate(Timestamp.valueOf("2017-07-25 05:00:00"));
        lot1.setFinishDate(Timestamp.valueOf("2017-07-27 05:00:00"));
        lot1.setOwner(user2);
        lot1.setLotStatus(lotStatus1);

        lot2 = new LotEntity();
        lot2.setId(2);
        lot2.setName("name2");
        lot2.setDescription("description2");
        lot2.setStartPrice(BigInteger.valueOf(200));
        lot2.setCategory(category2);
        lot2.setLotDate(Timestamp.valueOf("2017-08-21 04:05:06"));
        lot2.setStartDate(Timestamp.valueOf("2017-08-25 05:00:00"));
        lot2.setFinishDate(Timestamp.valueOf("2017-08-27 05:00:00"));
        lot2.setOwner(user2);
        lot2.setLotStatus(lotStatus1);

        image1 = new ImageEntity();
        image1.setId(1);
        image1.setLink("link1");
        image1.setLot(lot1);

        image2 = new ImageEntity();
        image2.setId(2);
        image2.setLink("link2");
        image2.setLot(lot1);

        image3 = new ImageEntity();
        image3.setId(3);
        image3.setLink("link3");
        image3.setLot(lot2);

        order1 = new OrderEntity();
        order1.setId(1);
        order1.setLot(lot1);
        order1.setOrderDate(Timestamp.valueOf("2017-07-25 15:05:06"));
        order1.setBuyer(user2);
        order1.setPrice(BigInteger.valueOf(200));
        order1.setOrderStatus(orderStatus1);

        order2 = new OrderEntity();
        order2.setId(2);
        order2.setLot(lot1);
        order2.setOrderDate(Timestamp.valueOf("2017-07-25 18:05:06"));
        order2.setBuyer(user2);
        order2.setPrice(BigInteger.valueOf(250));
        order2.setOrderStatus(orderStatus1);

        message1 = new MessageEntity();
        message1.setId(1);
        message1.setMessage("message1");
        message1.setMessageDate(Timestamp.valueOf("2017-07-25 15:05:06"));
        message1.setAuthor(user2);
        message1.setLot(lot1);

        message2 = new MessageEntity();
        message2.setId(2);
        message2.setMessage("message2");
        message2.setMessageDate(Timestamp.valueOf("2017-07-25 15:10:06"));
        message2.setAuthor(user2);
        message2.setLot(lot1);

        comment1 = new CommentEntity();
        comment1.setId(1);
        comment1.setMessage(message1);
        comment1.setComment("comment1");
        comment1.setCommentDate(Timestamp.valueOf("2017-07-25 15:10:06"));
        comment1.setAuthor(user1);

        comment2 = new CommentEntity();
        comment2.setId(2);
        comment2.setMessage(message1);
        comment2.setComment("comment2");
        comment2.setCommentDate(Timestamp.valueOf("2017-07-25 15:15:06"));
        comment2.setAuthor(user1);
    }

}
