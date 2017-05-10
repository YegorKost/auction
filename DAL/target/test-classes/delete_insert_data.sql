DELETE FROM comments;
DELETE FROM messages;
DELETE FROM orders;
DELETE FROM order_status;
DELETE FROM images;
DELETE FROM lots;
DELETE FROM users;
DELETE FROM roles;
DELETE FROM categories;
DELETE FROM lot_status;

INSERT INTO roles (id, role) VALUES (1, 'admin'), (2, 'user'), (3, 'user1');

INSERT INTO categories (id, category) VALUES (1, 'Cars'), (2, 'Art'), (3, 'Antiques');

INSERT INTO order_status (id, status) VALUES (1, 'transient'), (2, 'accept'), (3, 'deny');

INSERT INTO lot_status (id, status) VALUES (1, 'await'), (2, 'open'), (3, 'close');

INSERT INTO users (id, email, first_name, last_name, login, password, phone_number, role_id)
VALUES (1, 'e1@mail.com', 'first1', 'last1', 'login1', 'password1', '1111111111', 1),
(2, 'e2@mail.com', 'first2', 'last2', 'login2', 'password2', '2222222222', 2);

INSERT INTO lots (id, name, description, start_price, category_id, lot_date, start_date, finish_date, owner, lot_status_id)
VALUES (1, 'name1', 'description1', 100, 1, '2017-07-21 04:05:06', '2017-07-25 05:00:00', '2017-07-27 05:00:00', 2, 1),
(2, 'name2', 'description2', 200, 2, '2017-08-21 04:05:06', '2017-08-25 05:00:00', '2017-08-27 05:00:00', 2, 2);

INSERT INTO images (id, link, lot_id) VALUES (1, 'link1', 1), (2, 'link2', 1), (3, 'link3', 1);

INSERT INTO orders (id, lot_id, order_date, buyer, price, order_status_id)
VALUES (1, 1, '2017-07-25 15:05:06', 2, 200, 1),
(2, 1, '2017-07-25 18:05:06', 2, 250, 1);

INSERT INTO messages (id, message, message_date, author, lot_id)
VALUES (1, 'message1', '2017-07-25 15:05:06', 2, 1),
(2, 'message2', '2017-07-25 15:10:06', 2, 1);

INSERT INTO comments (id, message_id, comment, comment_date, author)
VALUES (1, 1, 'comment1', '2017-07-25 15:10:06', 2),
(2, 1, 'comment2', '2017-07-25 15:15:06', 2);

