package br.com.selat.productservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="PRODUCTS")
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private Long userId;

    @Transient
    private User user;

    public Product() {
    }

    public Product(Long id, String name, Long userId, User user) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
