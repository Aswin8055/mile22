package com.examly.springapp.service;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    // In-memory storage for users
    private final Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUserById(Long id) {
        return users.get(id);
    }

    @Override
    public User createUser(User user) {
        // Generate new ID if not provided
        if (user.getId() == null) {
            user.setId(nextId++);
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        if (!users.containsKey(id)) {
            return null;
        }

        User existingUser = users.get(id);

        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }
        if (user.getProfilePicture() != null) {
            existingUser.setProfilePicture(user.getProfilePicture());
        }

        return existingUser;
    }

    @Override
    public void deleteUser(Long id) {
        users.remove(id);
    }
}