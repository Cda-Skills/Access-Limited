package org.example.accesLimited.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity /* (debug = true) */
public class SecurityConfig {

	/* The new way : (September 2023) */

	
	
	/* PasswordEncoder Works */
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/* This UNDER needs to be custumized but works that way */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
		
		.csrf(AbstractHttpConfigurer::disable)
		
	    // Here we are configuring our login form :
		
	    .formLogin(Customizer.withDefaults())

				.authorizeHttpRequests((authorize) -> {
					
					authorize.requestMatchers("/","public/**").permitAll();
					authorize.requestMatchers("/admin/**").hasRole("ADMIN");
					authorize.requestMatchers("/user/**").hasAnyRole("USER","ADMIN");
					authorize.anyRequest().authenticated();
					
				})
				.logout(Customizer.withDefaults())
	
				.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}

	
	
	/* This UNDER is Good */
	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails userOne = User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER")
				.build();

		UserDetails aDmin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(userOne, aDmin);
	}
}
