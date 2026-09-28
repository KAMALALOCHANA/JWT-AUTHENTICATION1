package com.Jwt.Token.controllers;

import com.Jwt.Token.Models.User;
import com.Jwt.Token.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class Homecontroller {
    @Autowired
    private UserServices userService;
     @GetMapping("/users")
    public List<User> getUser() {
    System.out.println("getting users");
         return userService.getUsers();
    }
    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal)
    {
        return principal.getName();
    }

}
