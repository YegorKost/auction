package com.yegor.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by YegorKost on 26.04.2017.
 */
@Entity
@Table(name = "lots")
@NamedQueries({@NamedQuery(name = "getAllLots", query = "SELECT l FROM LotEntity l"),
        @NamedQuery(name = "getLotsByName", query = "SELECT l FROM LotEntity l where l.name = :name")})
public class LotEntity {
    private long id;
    private String name;
    private String description;
    private BigInteger startPrice;
    private Timestamp lotDate;
    private Timestamp startDate;
    private Timestamp finishDate;
    private CategoryEntity category;
    private UserEntity owner;
    private LotStatusEntity lotStatus;

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
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "start_price", nullable = false)
    public BigInteger getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigInteger startPrice) {
        this.startPrice = startPrice;
    }

    @Basic
    @Column(name = "lot_date", nullable = false)
    public Timestamp getLotDate() {
        return lotDate;
    }

    public void setLotDate(Timestamp date) {
        this.lotDate = date;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "finish_date", nullable = false)
    public Timestamp getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @ManyToOne
    @JoinColumn(name = "lot_status_id", nullable = false)
    public LotStatusEntity getLotStatus() {
        return lotStatus;
    }

    public void setLotStatus(LotStatusEntity lotStatus) {
        this.lotStatus = lotStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotEntity that = (LotEntity) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!description.equals(that.description)) return false;
        if (!startPrice.equals(that.startPrice)) return false;
        if (!lotDate.equals(that.lotDate)) return false;
        if (!startDate.equals(that.startDate)) return false;
        return finishDate.equals(that.finishDate);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + startPrice.hashCode();
        result = 31 * result + lotDate.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + finishDate.hashCode();
        return result;
    }
}
