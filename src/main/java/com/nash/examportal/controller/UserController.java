package com.nash.examportal.controller;

import com.nash.examportal.helper.UserFoundException;
import com.nash.examportal.model.Role;
import com.nash.examportal.model.User;
import com.nash.examportal.model.UserRole;
import com.nash.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfileImgPath("default.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = new Role();
        role.setRoleId(27L);
        role.setRoleName("NORMAL");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        Set<UserRole> userRoleSet = new HashSet<>();
        userRoleSet.add(userRole);
        return this.userService.createUser(user, userRoleSet);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return new ResponseEntity<>("User already exits! Try other username", HttpStatus.FOUND);
    }
}
