package com.yegor.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by YegorKost on 26.04.2017.
 */
@Entity
@Table(name = "orders")
@NamedQuery(name = "getAllOrders", query = "SELECT o FROM OrderEntity o")
public class OrderEntity {
    private long id;
    private Timestamp orderDate;
    private BigInteger price;
    private LotEntity lot;
    private UserEntity buyer;
    private OrderStatusEntity orderStatus;

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
    @Column(name = "order_date", nullable = false)
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp date) {
        this.orderDate = date;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "lot_id", nullable = false)
    public LotEntity getLot() {
        return lot;
    }

    public void setLot(LotEntity lot) {
        this.lot = lot;
    }

    @ManyToOne
    @JoinColumn(name = "buyer", nullable = false)
    public UserEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(UserEntity buyer) {
        this.buyer = buyer;
    }

    @ManyToOne
    @JoinColumn(name = "order_status_id", nullable = false)
    public OrderStatusEntity getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEntity orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (!orderDate.equals(that.orderDate)) return false;
        return price.equals(that.price);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
