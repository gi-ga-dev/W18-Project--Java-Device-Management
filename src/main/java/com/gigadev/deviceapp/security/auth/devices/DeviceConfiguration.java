package com.gigadev.deviceapp.security.auth.devices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
public class DeviceConfiguration {
				
	@Bean("device1")	
	public Device newDevice() {
		Device device1 = new Device(DeviceType.LAPTOP, DeviceStatus.AVAILABLE);				
		return device1;
	}	
	
}
