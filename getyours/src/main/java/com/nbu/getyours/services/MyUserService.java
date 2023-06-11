package com.nbu.getyours.services;

import com.nbu.getyours.models.MyUser;
import com.nbu.getyours.repos.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserService {

    @Autowired
    private MyUserRepository userRepository;

    public List<MyUser> getAll() {
        return this.userRepository.findAll();
    }

    public MyUser getById(Long id) {
        Optional<MyUser> user = this.userRepository.findById(id);
        if (user.isEmpty()) {
            System.out.println("User with id " + id + " does not exist");
            return null;
        }

        return user.get();
    }

    public MyUser getByEmail(String email) {
        Optional<MyUser> user = this.userRepository.findByEmail(email);
        if (user.isEmpty()) {
            System.out.println("User with email " + email + " does not exist");
            return null;
        }

        return user.get();
    }

    public MyUser add(MyUser user) {
        MyUser newUser = null;
        if (this.userRepository.findByEmail(user.getEmail()).isPresent()) {
            System.out.println("User with email " + user.getEmail() + " already exists");
        } else {
            newUser = this.userRepository.save(user);
        }

        return newUser;
    }

    public void delete(MyUser user) {
        this.userRepository.delete(user);
    }
}
