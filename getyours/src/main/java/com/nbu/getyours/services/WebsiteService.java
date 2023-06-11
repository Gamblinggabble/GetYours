package com.nbu.getyours.services;

import com.nbu.getyours.models.Website;
import com.nbu.getyours.repos.WebsiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebsiteService {

    @Autowired
    private WebsiteRepo websiteRepository;

    public List<Website> getAll() {
        return websiteRepository.findAll();
    }

    public Website getByName(String name) {
        Optional<Website> website = this.websiteRepository.findByName(name);
        if (website.isEmpty()) {
            System.out.println("Website with id " + name + " does not exist");
            return null;
        }

        return website.get();
    }

}
