package com.example.tag.service;

import org.springframework.security.oauth2.core.user.OAuth2User;

public interface UserService {
    void checkUser(String username);

    void googleLogin(OAuth2User user);
}
