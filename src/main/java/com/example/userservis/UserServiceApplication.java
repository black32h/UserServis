package com.example.userservis;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class UserServisApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServisApplication.class, args);
    }

}
@RestController
@RequestMapping("/api/users")
class UserController {
    private final Map<Long, User> users = new HashMap<>();

}
