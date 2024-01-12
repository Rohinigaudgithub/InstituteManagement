package com.rohini.institute.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rohini.institute.management.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class IrsLoginConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	@Autowired
	private AuthenticationEntryPoint unAuthorizedHandler;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Bean
//	public AuthenticationManager authenticationManager(HttpSecurity http, NoOpPasswordEncoder noOpPasswordEncoder)
//			throws Exception {
//		AuthenticationManagerBuilder authenticationManagerBuilder = http
//				.getSharedObject(AuthenticationManagerBuilder.class);
//		authenticationManagerBuilder.userDetailsService(userDetailsServiceImpl).passwordEncoder(noOpPasswordEncoder);
//		return authenticationManagerBuilder.build();
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		System.out.println("Password encoder..............");
//		return new BCryptPasswordEncoder(); // NoOpPasswordEncoder.getInstance();
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configure !!!!!!!..............");
		auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
				.authorizeRequests(requests -> requests.antMatchers("/api/v1/generate-token", "/api/v1/user/")
						.permitAll().antMatchers(HttpMethod.OPTIONS).permitAll()
						// Restrict access based on roles
						.antMatchers("/InstituteManagement/register").hasRole("ADMIN")
						.antMatchers("/InstituteManagement/getAllInstitutes").hasAnyRole("NORMAL").anyRequest()
						.authenticated())
				.exceptionHandling(handling -> handling.authenticationEntryPoint(unAuthorizedHandler))
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
