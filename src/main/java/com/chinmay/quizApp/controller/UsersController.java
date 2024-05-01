package com.chinmay.quizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chinmay.quizApp.model.Users;
import com.chinmay.quizApp.service.UsersService;


@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
    private UsersService userService;
    
    @PostMapping("/addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        return new ResponseEntity<Users>(userService.saveUser(user), HttpStatus.CREATED);
    }
    
    
    
    
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {
        userService.deleteUser(email);
        return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
    }
    
    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{email}")
    public Users getUserById(@PathVariable String email) {
        return userService.getUserById(email);
    }
    
    
//    http://localhost:8081/users/update?email=user2@example.com&newName=Chinmay&newPassword=1234
    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(
            @RequestParam String email,
            @RequestParam String newName,
            @RequestParam double newPassword) {

        try {
            userService.updateProduct(email, newName, newPassword);
            return ResponseEntity.ok("User updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update product.");
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String email,
            @RequestParam String password) {

        try {
            if (userService.validateUser(email, password)) {
                return ResponseEntity.ok("Login successful.");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to login.");
        }
    }
    
    
    
}
