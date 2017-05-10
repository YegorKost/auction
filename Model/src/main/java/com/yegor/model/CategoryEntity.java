package com.yegor.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by YegorKost on 26.04.2017.
 */
@Entity
@Table(name = "categories")
@NamedQuery(name = "getAllCategories", query = "SELECT c FROM CategoryEntity c")
public class CategoryEntity implements Serializable{
    private int id;
    private String category;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (id != that.id) return false;
        return category.equals(that.category);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + category.hashCode();
        return result;
    }
}
