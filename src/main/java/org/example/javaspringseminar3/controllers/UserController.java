package org.example.javaspringseminar3.controllers;

import org.example.javaspringseminar3.domain.User;
import org.example.javaspringseminar3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
//        registrationService.getDataProcessingService().getRepository().getUsers().add(user);
//        return "User added from body!";

        registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User added successfully";
    }

    @PostMapping("/param")
    public String userAddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        registrationService.processRegistration(name, age, email);
        return "User added successfully";
    }
}
