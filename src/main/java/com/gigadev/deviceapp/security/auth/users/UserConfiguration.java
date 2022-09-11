package com.gigadev.deviceapp.security.auth.users;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.gigadev.deviceapp.security.auth.devices.Device;
import com.gigadev.deviceapp.security.auth.devices.DeviceDto;
import com.gigadev.deviceapp.security.auth.roles.ERole;
import com.gigadev.deviceapp.security.auth.roles.Role;

@Configuration
public class UserConfiguration {
		
	@Autowired @Qualifier("admin1") Role adminRole;
	@Autowired @Qualifier("employee1") Role emplRole;
	
	//private Set<Role> roles = new HashSet<>();
	//@Autowired @Qualifier("device1") DeviceDto device1;
	
	@Bean("user1")
	public User newUser() {
		User user1 = new User("gigadev", "Gianluke Gallons", "123vattelapesca");
		user1.addRole(emplRole);
		//roles.add(emplRole);
		//user1.setRoles(roles);
		
		// aggiungere controllo-->solo se l'utente e' admin aggiungi
		//user1.addDevice(device1);
		
		return user1;
	}
}
