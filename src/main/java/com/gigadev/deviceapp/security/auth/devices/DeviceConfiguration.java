package com.gigadev.deviceapp.security.auth.devices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
public class DeviceConfiguration {
				
	@Bean("device1")	
	public DeviceDto newDevice() {
		DeviceDto device1 = new DeviceDto(DeviceType.LAPTOP, DeviceStatus.AVAILABLE);				
		return device1;
	}	
	
}
