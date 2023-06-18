package com.nbu.getyours.repos;

import com.nbu.getyours.models.MyUser;
import com.nbu.getyours.models.ProductItem;
import com.nbu.getyours.models.Subscription;
import com.nbu.getyours.models.SubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, SubscriptionId> {
    List<Subscription> findByUser(MyUser user);

    List<Subscription> findByProductItem(ProductItem item);

    List<Subscription> findAllByUser(MyUser byEmail);
}
