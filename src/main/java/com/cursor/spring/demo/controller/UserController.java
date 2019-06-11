package com.cursor.spring.demo.controller;

import com.cursor.spring.demo.dto.UserDTO;
import com.cursor.spring.demo.entity.User;
import com.cursor.spring.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/email")
    public User getUserByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/create")
    public User updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @GetMapping("/emails")
    public List<String> getUsersEmails(){
        return userService.findUsersOnlyWirhEmails();
    }
}
