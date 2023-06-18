package com.nbu.getyours.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(SubscriptionId.class)
public class Subscription {

    @Id
    @ManyToOne
    private MyUser user;
    @Id
    @ManyToOne
    private ProductItem productItem;

    public Subscription() {
    }

    public Subscription(MyUser user, ProductItem productItem) {
        this.user = user;
        this.productItem = productItem;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        this.productItem = productItem;
    }
}
