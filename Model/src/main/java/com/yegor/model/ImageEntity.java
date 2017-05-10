package com.yegor.model;

import javax.persistence.*;

/**
 * Created by YegorKost on 26.04.2017.
 */
@Entity
@Table(name = "images")
@NamedQuery(name = "getAllImages", query = "SELECT i FROM ImageEntity i")
public class ImageEntity {
    private long id;
    private String link;
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
    @Column(name = "link", nullable = false)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

        ImageEntity that = (ImageEntity) o;

        if (id != that.id) return false;
        return link.equals(that.link);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + link.hashCode();
        return result;
    }
}
