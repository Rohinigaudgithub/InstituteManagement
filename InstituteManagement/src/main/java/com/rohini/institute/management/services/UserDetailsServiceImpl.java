package com.rohini.institute.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rohini.institute.management.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.rohini.institute.management.model.User userByUserName = userRepository.findByUsername(username);
		System.out.println("userByUserName : : : : : "+userByUserName);
		if (userByUserName == null) {
			throw new UsernameNotFoundException("No user found !");	
		}
		return (UserDetails) userByUserName;
		
	}

}
