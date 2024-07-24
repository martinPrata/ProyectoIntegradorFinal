package com.educacionit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educacionit.entity.Role;
import com.educacionit.entity.User;
import com.educacionit.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addRoleToUser(Long userId, Role role) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }
}
