package com.akbadejava.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDao {
    //JPA/Hibernate -> Database
    // UserDao -> Static List
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount,"Joey", LocalDate.now().minusYears(29)));
        users.add(new User(++userCount,"Chandler", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Monica", LocalDate.now().minusYears(28)));
    }

    //public List<User> findAll() {}
    public List<User> findAll() {
        return users;
    }

    //public User save(User user) {}
    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    //public User findOne(int id) {}
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
