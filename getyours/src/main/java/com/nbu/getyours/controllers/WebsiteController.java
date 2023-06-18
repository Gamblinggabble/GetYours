package com.nbu.getyours.controllers;

import com.nbu.getyours.models.Website;
import com.nbu.getyours.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/websites")
@CrossOrigin(origins = "http://localhost:4200")
public class WebsiteController {

    @Autowired
    private WebsiteService websiteService;

    @GetMapping("/all")
    public List<Website> getAll() {
        return this.websiteService.getAll();
    }

    @GetMapping("/{websiteName}")
    public Website getById(@PathVariable String websiteName) {
        return this.websiteService.getByName(websiteName);
    }

}
