package com.nash.examportal.service;

import com.nash.examportal.model.User;
import com.nash.examportal.model.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoleSet) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);
}
