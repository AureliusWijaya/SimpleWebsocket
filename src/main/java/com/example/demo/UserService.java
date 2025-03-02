package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserResponse save(UserRequest user) {
        User test = User.builder()
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();

        userRepository.save(test);

        return UserResponse.builder()
                .email(user.getName())
                .name(user.getName())
                .build();
    }
    public List<User> findAll () {
        return userRepository.findAll();
    }
}
