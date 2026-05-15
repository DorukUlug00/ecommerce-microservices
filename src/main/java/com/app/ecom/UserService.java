package com.app.ecom;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;

import java.util.ArrayList;

@Slf4j
@Service
public class UserService {


    private List<User> users = new ArrayList<>();


    public List<User> fetchAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> fetchUser(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public boolean updateUser(long id, User updatedUser) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .map(u -> {
                    u.setFirstName(updatedUser.getFirstName());
                    u.setLastName(updatedUser.getLastName());
                    return true;
                })
                .orElse(false);
    }
}
