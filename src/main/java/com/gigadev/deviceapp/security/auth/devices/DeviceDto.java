package com.gigadev.deviceapp.security.auth.devices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
	
	private DeviceType deviceType;
	private DeviceStatus deviceStatus;
}
