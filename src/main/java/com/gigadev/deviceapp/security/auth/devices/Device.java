package com.gigadev.deviceapp.security.auth.devices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gigadev.deviceapp.security.auth.users.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "devices")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	DeviceType deviceType;
	DeviceStatus deviceStatus;
	
	@ManyToOne
	private User user;

	public Device(DeviceType deviceType, DeviceStatus deviceStatus) {
		super();
		this.deviceType = deviceType;
		this.deviceStatus = deviceStatus;
	}
	
	
}
