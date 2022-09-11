package com.gigadev.deviceapp.security.auth.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gigadev.deviceapp.security.auth.roles.Role;

@Configuration
public class UserConfiguration {
		
	@Autowired @Qualifier("admin1") Role adminRole;
	@Autowired @Qualifier("employee1") Role employeeRole;
	@Autowired @Qualifier("visitor1") Role visitorRole;
			
	@Bean("user1")
	public User newUser() {
		User user1 = new User("gigadev", "Gianluke Gallons", "123vattelapesca");
		// aggiungi ruolo alla lista di ruoli dell'utente
		// il ruolo viene attribuito alla creazione dell'utente
		// quindi se l'utente avra' nella lista di ruoli empl e/o admin potra' prendere devices
		user1.addRole(adminRole);
		System.out.println("_____________" + user1.getRoles());
		return user1;
	}
}
