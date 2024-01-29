package com.example.tag.service;

import com.example.tag.exception.UserException;
import com.example.tag.model.User;
import com.example.tag.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void checkUser(String username) {
        User user = userRepository.findByUsername(username);

        if(user == null || !user.isActiveUser() || user.isBanned()){
            throw new UserException("User not found");
        }
    }
}
