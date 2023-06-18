package com.nbu.getyours.controllers;

import com.nbu.getyours.models.MyUser;
import com.nbu.getyours.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class MyUserController {

    @Autowired
    private MyUserService userService;

    @GetMapping("/all")
    public List<MyUser> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public MyUser getById(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @GetMapping()
    public MyUser getByEmail(@RequestParam String email) {
        System.out.println("In controller getByEmail - " + email);
//        System.out.println(this.userService.getByEmail(email).getEmail());
        return this.userService.getByEmail(email);
    }

    @PostMapping("/add")
    public MyUser add(@RequestBody MyUser user) {
        return this.userService.add(user);
    }

    @PostMapping("delete")
    public void deleteUser(@RequestBody MyUser user) {
        this.userService.delete(user);
    }

}
