package com.gigadev.deviceapp.security.auth.devices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceConfiguration {
		
	@Bean("device1")	
	public Device newDevice() {
		// creazione oggetto laptop disponibile per essere assegnato
		return new Device(DeviceType.LAPTOP, DeviceStatus.AVAILABLE);
	}	
	
	// creare USER con parametri del login
	// attribuire all'utente privilegi EMPLOYEE e/o ADMIN
	
	// creare DEVICE non attribuito a nessuno
	// l'utente che ha i privilegi almeno da EMPLOYEE puo' prendere un device AVAILABLE
	// device.setUser(user1)
	// quando e' stato preso, lo status del device diventa ASSIGNED e viene cosi' salvato nel db con associazione
	// se (il DeviceStatus del LAPTOP == ASSIGNED) salva nel db
}
