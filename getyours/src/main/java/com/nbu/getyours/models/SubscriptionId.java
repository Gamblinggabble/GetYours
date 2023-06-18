package com.nbu.getyours.models;

import java.io.Serializable;
import java.util.Objects;

public class SubscriptionId implements Serializable {

    private MyUser user;
    private ProductItem productItem;

    public SubscriptionId() {
    }

    public SubscriptionId(MyUser user, ProductItem productItem) {
        this.user = user;
        this.productItem = productItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionId that = (SubscriptionId) o;
        return user.equals(that.user) && productItem.equals(that.productItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, productItem);
    }
}
