package com.nash.examportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ExamportalApplication.class, args);
		System.out.println("------Application Started---------");
	}

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
//		role1.setRoleId(44L);
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
