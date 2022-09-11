package com.gigadev.deviceapp.security.auth.devices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceConfiguration {
		
	@Bean("device1")	
	public Device newDevice() {
		// laptop disponibile per essere assegnato
		return new Device(DeviceType.LAPTOP, DeviceStatus.AVAILABLE);
	}

}
