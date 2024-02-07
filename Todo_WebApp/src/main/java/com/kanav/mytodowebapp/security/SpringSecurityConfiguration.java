package com.kanav.mytodowebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

	/*
	 * For authentication we use either LDAP or database Or we can also use InMemory
	 * also
	 * 
	 * InMemoryUserDetailsManager(UserDetails ...users)
	 */

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetials1 = getUserDetails("Kanav Sharma", "password");
		UserDetails userDetials2 = getUserDetails("Kanav", "1234");

		return new InMemoryUserDetailsManager(userDetials1, userDetials2);
	}

	private UserDetails getUserDetails(String username, String password) {

		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		return User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
				.roles("USER", "ADMIN").build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChaini(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(Customizer.withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}
