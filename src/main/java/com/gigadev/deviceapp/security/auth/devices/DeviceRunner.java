package com.gigadev.deviceapp.security.auth.devices;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.gigadev.deviceapp.security.auth.roles.RoleConfiguration;
import com.gigadev.deviceapp.security.auth.roles.RoleService;
import com.gigadev.deviceapp.security.auth.users.UserConfiguration;
import com.gigadev.deviceapp.security.auth.users.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class DeviceRunner implements ApplicationRunner {
	
	DeviceConfiguration deviceConfig;
	DeviceService deviceServ;
	
	UserConfiguration userConfig;
	UserService userServ;
	
	RoleConfiguration roleConfig;
	RoleService roleServ;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("--> Application Started Successfully!!!");
		
		userServ.create(userConfig.newUser());
		deviceServ.create(deviceConfig.newDevice());
		
	}

}
