package com.example.demo.services;


import com.example.demo.modal.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public void saveMyUser(User user ) {
        userRepository.save(user);
    }

}
