package com.example.tag.controller;


import com.example.tag.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> home(@AuthenticationPrincipal OAuth2User user) {
        userService.googleLogin(user);
        return ResponseEntity.ok("OK");
    }
}


