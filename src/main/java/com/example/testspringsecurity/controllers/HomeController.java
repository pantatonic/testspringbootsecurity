package com.example.testspringsecurity.controllers;

import com.example.testspringsecurity.entities.User;
import com.example.testspringsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/home")
    public String home() {
        Optional<User> optionalUser = userService.getById(1);

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();

            System.out.println(user.getUsername());
        }

        return "This is home page";
    }

    @GetMapping(value = "/admin")
    public String admin() {
        return "This is admin page";
    }

    @PostMapping(value = "/logout")
    public void logout(HttpSession httpSession) {
        /* System.out.println("logout");

        httpSession.invalidate(); */
    }

}
