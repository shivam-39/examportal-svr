package com.nash.examportal.service.impl;

import com.nash.examportal.model.User;
import com.nash.examportal.model.UserRole;
import com.nash.examportal.repository.RoleRepository;
import com.nash.examportal.repository.UserRepository;
import com.nash.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User createUser(User user, Set<UserRole> userRoleSet) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null){
            System.out.println("User is already there!!");
            throw new Exception("User already exists!!");
        }else{
            for(UserRole ur:userRoleSet){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoleSet().addAll(userRoleSet);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }


}
