package com.rohini.institute.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rohini.institute.management.repositories.UserRepository;


@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.rohini.institute.management.model.User userByUserName = userRepository.findByUsername(username);
		Set<Role> set = new HashSet<>();
		Role role = new Role();
		role.setRole("ROLE_ADMIN");
		role.setId(1);
		role.setStatus(true);
		set.add(role);
		
		userByUserName.setRoles(set);
		System.out.println("userByUserName : : : : : "+userByUserName);
		if (userByUserName == null) {
			throw new UsernameNotFoundException("No user found !");	
		}
		return (UserDetails) userByUserName;
		
	}
}
