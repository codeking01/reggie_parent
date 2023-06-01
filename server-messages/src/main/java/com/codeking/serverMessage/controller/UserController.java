package com.codeking.serverMessage.controller;

import com.codeking.serverMessage.entity.Users;
import com.codeking.serverMessage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody Users users) {
        int result = userService.saveUser(users);
        if (result > 0) {
            return ResponseEntity.ok("Users saved successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to save users");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getId(userId));
    }
}
