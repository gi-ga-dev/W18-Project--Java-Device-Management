package com.gigadev.deviceapp.security.auth.devices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gigadev.deviceapp.security.auth.roles.Role;
import com.gigadev.deviceapp.security.auth.users.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DeviceConfiguration {
	
	@Autowired @Qualifier("admin1") Role adminRole;
	@Autowired @Qualifier("employee1") Role employeeRole;
	@Autowired @Qualifier("visitor1") Role visitorRole;
		
	@Bean("device1")	
	public Device newDevice() {
		Device device1 = new Device(DeviceType.LAPTOP, DeviceStatus.AVAILABLE);				
		return device1;
	}	
	
	// ritorna device con utente assegnato
	public Device assignDevice(Device device, User user) {			
		// se la lista ruoli utente del parametro contiene un oggetto ruolo EMPLOYEE o ADMIN (adminRole/emplRole)
		if(user.getRoles().contains(employeeRole) || user.getRoles().contains(adminRole) ) {
			device.setUser(user);	
			device.setDeviceStatus(DeviceStatus.ASSIGNED);
		} else { log.info("____ Device cannot be assigned to an account with Role: VISITOR"); }
		return device;
	}
	
	// creare USER con parametri del login
	// attribuire all'utente privilegi EMPLOYEE e/o ADMIN
	
	// creare DEVICE (con parametro utente da attribuire) non attribuito a nessuno 
	// solo l'utente che ha i privilegi almeno da EMPLOYEE puo' prendere un device AVAILABLE
	// device.setUser(user1)
	// quando e' stato preso, lo status del device diventa ASSIGNED e viene cosi' salvato nel db con associazione
	// se (il DeviceStatus del LAPTOP == ASSIGNED) non puo' essere preso da un altro utente
}
