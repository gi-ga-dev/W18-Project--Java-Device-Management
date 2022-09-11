package com.gigadev.deviceapp.security.auth.roles;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RoleConfiguration {
	
	@Bean("admin1")
	public Role newAdmin() {
		return new Role(ERole.ROLE_ADMIN);
	}
	
	@Bean("employee1")
	public Role newEmployee() {
		return new Role(ERole.ROLE_EMPLOYEE);
	}

}
