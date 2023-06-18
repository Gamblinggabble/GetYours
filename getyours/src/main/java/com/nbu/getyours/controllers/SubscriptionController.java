package com.nbu.getyours.controllers;

import com.nbu.getyours.models.MyUser;
import com.nbu.getyours.models.Subscription;
import com.nbu.getyours.services.MyUserService;
import com.nbu.getyours.services.ProductItemService;
import com.nbu.getyours.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "http://localhost:4200")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private MyUserService userService;
    @Autowired
    private ProductItemService productItemService;

    @GetMapping("/all")
    public List<Subscription> getAll(
            @RequestParam(required = false) Optional<String> userEmail,
            @RequestParam(required = false) Optional<String> itemUrl
    ) {
        if (userEmail.isPresent() && itemUrl.isPresent()) {
            List<Subscription> filteredByItemUrl = this.subscriptionService.getByProductItem(productItemService.getById(itemUrl.get()));
            return this.subscriptionService.getByUser(userService.getByEmail(userEmail.get())).stream().filter(s -> filteredByItemUrl.contains(s)).collect(Collectors.toList());
        } else if (userEmail.isPresent()) {
            return this.subscriptionService.getByUser(userService.getByEmail(userEmail.get()));
        } else if (itemUrl.isPresent()) {
            return this.subscriptionService.getByProductItem(productItemService.getById(itemUrl.get()));
        }
        return this.subscriptionService.getAll();
    }

    @PostMapping("/add")
    public Subscription add(@RequestBody Subscription subscription) {
        return this.subscriptionService.add(subscription);
    }

    @PostMapping("delete")
    public void delete(@RequestBody Subscription subscription) {
        this.subscriptionService.delete(subscription);
    }

}
