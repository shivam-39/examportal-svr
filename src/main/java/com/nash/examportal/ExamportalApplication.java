package com.nash.examportal;

import com.nash.examportal.model.Role;
import com.nash.examportal.model.User;
import com.nash.examportal.model.UserRole;
import com.nash.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ExamportalApplication.class, args);
		System.out.println("------Application Started---------");
	}

	@Autowired
	UserService userService;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("----*****----");
//		User user1 = new User();
//		user1.setFirstName("f-2");
//		user1.setLastName("l-2");
//		user1.setUsername("user-44");
//		user1.setPassword("pass-1");
//		user1.setEmail("e-2@email.com");
//		user1.setProfileImgPath("/src/default.png");
//
//		Role role1 = new Role();
//		role1.setRoleId(13L);
//		role1.setRoleName("ADMIN");
//
//		UserRole userRole = new UserRole();
//		userRole.setUser(user1);
//		userRole.setRole(role1);
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		userRoleSet.add(userRole);
//
//		User user2 = this.userService.createUser(user1, userRoleSet);
//		System.out.println(user2.getUsername());
	}
}
