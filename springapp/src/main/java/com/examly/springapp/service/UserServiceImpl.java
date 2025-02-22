// UserServiceImpl.java
package com.examly.springapp.service;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}