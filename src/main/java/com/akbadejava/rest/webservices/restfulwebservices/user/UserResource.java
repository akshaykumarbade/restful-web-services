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
        User user = userDao.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id "+ id);
        }
        return user;
    }

    //POST /users
    @PostMapping("/users")
    public void createuser(@RequestBody User user) {
        userDao.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userDao.deleteUserById(id);
    }
}
