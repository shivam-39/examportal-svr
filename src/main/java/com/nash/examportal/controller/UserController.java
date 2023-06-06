package com.nash.examportal.controller;

import com.nash.examportal.model.Role;
import com.nash.examportal.model.User;
import com.nash.examportal.model.UserRole;
import com.nash.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Role role = new Role();
        role.setRoleId(27L);
        role.setRoleName("NORMAL");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        Set<UserRole> userRoleSet = new HashSet<>();
        userRoleSet.add(userRole);
        user.setProfileImgPath("default.png");
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
}
