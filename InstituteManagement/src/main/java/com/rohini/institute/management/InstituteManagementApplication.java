package com.rohini.institute.management;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rohini.institute.management.model.Role;
import com.rohini.institute.management.model.User;
import com.rohini.institute.management.repositories.UserRepository;

@SpringBootApplication
public class InstituteManagementApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(InstituteManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setUsername("Priyanka");
		user1.setPassword("nka@123");
		Role roleDTO1 = new Role();
		roleDTO1.setRole("ROLE_ADMIN");
		roleDTO1.setStatus(true);
		Set<Role> roles1 = new HashSet<>();
		roles1.add(roleDTO1);
		user1.setRoles(roles1);
		this.userRepository.save(user1);

	}
}
