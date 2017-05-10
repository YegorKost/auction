package com.yegor.model;

import javax.persistence.*;

/**
 * Created by YegorKost on 26.04.2017.
 */
@Entity
@Table(name = "roles")
@NamedQuery(name = "getAllRoles", query = "SELECT r FROM RoleEntity r")
public class RoleEntity {
    private int id;
    private String role;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        return role.equals(that.role);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + role.hashCode();
        return result;
    }
}
