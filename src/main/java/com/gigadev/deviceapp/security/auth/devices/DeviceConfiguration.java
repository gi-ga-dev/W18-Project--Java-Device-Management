package com.gigadev.deviceapp.security.auth.devices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceConfiguration {
		
	@Bean("device1")	
	public Device newDevice() {
		return new Device(DeviceType.LAPTOP, DeviceStatus.ASSIGNED);
	}

}
