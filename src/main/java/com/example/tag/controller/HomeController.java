package com.example.tag.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("HOME");
    }
}


