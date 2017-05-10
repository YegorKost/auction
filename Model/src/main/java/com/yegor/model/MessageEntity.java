package com.yegor.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YegorKost on 27.04.2017.
 */
@Entity
@Table(name = "messages")
@NamedQuery(name = "getAllMessages", query = "SELECT m FROM MessageEntity m")
public class MessageEntity {
    private long id;
    private String message;
    private Timestamp messageDate;
    private UserEntity author;
    private LotEntity lot;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message", nullable = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "message_date", nullable = false)
    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp date) {
        this.messageDate = date;
    }

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "lot_id", nullable = false)
    public LotEntity getLot() {
        return lot;
    }

    public void setLot(LotEntity lot) {
        this.lot = lot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != that.id) return false;
        if (!message.equals(that.message)) return false;
        return messageDate.equals(that.messageDate);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + message.hashCode();
        result = 31 * result + messageDate.hashCode();
        return result;
    }
}
