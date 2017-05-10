package com.yegor.model;

import javax.persistence.*;

/**
 * Created by YegorKost on 26.04.2017.
 */
@Entity
@Table(name = "lot_status")
@NamedQuery(name = "getAllLotsStatuses", query = "SELECT ls FROM LotStatusEntity ls")
public class LotStatusEntity {
    private int id;
    private String status;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotStatusEntity that = (LotStatusEntity) o;

        if (id != that.id) return false;
        return status.equals(that.status);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + status.hashCode();
        return result;
    }
}
