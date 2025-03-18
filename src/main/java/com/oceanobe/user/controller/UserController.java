package com.oceanobe.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    @GetMapping("/user")
    public void createUser() {
        log.info("Created user (not really though, hehe - we set up no persistence, for now at least)");
        ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
