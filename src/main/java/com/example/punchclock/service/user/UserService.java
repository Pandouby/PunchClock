package com.example.punchclock.service.user;

import com.example.punchclock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean findUser(User user) {
        return userRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
