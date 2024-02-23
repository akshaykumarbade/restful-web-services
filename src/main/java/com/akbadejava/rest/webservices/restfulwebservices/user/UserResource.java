package com.akbadejava.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    private UserDao userDao;
    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }
    //Get /users
    @GetMapping("/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }

    //Get /users/1

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userDao.findOne(id);
    }

    //POST /users
    @PostMapping("/users")
    public void createuser(@RequestBody User user) {
        userDao.save(user);
    }
}
