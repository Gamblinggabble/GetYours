package com.nbu.getyours.services;

import com.nbu.getyours.models.*;
import com.nbu.getyours.repos.MyUserRepository;
import com.nbu.getyours.repos.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepo subscriptionRepository;
    @Autowired
    private MyUserRepository userRepository;

    public List<Subscription> getAll() {
        return this.subscriptionRepository.findAll();
    }

    public List<Subscription> getByUser(MyUser user) {
        return this.subscriptionRepository.findByUser(user);
    }

    public List<Subscription> getByProductItem(ProductItem item) {
        return this.subscriptionRepository.findByProductItem(item);
    }

    public Subscription add(Subscription subscription) {
        Subscription newSubscription = null;
        if (this.subscriptionRepository.findById(new SubscriptionId(subscription.getUser(), subscription.getProductItem())).isPresent()) {
            System.out.println("The user with email " + subscription.getUser().getEmail() + " has already subscribed for product with url " + subscription.getProductItem().getItem_url());
        } else {
            newSubscription = this.subscriptionRepository.save(subscription);
        }

        return newSubscription;
    }

    public void delete(Subscription subscription) {
        this.subscriptionRepository.delete(subscription);
    }

    public List<ProductItem> getAllByUser(String user) {
        return this.subscriptionRepository.findAllByUser(userRepository.findByEmail(user).get()).stream().map(s -> s.getProductItem()).collect(Collectors.toList());
    }
}
