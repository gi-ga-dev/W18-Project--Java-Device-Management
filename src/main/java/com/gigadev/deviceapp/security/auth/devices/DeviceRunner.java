package com.gigadev.deviceapp.security.auth.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.gigadev.deviceapp.security.auth.users.User;
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
		
	@Autowired @Qualifier("user1") User user1;
	@Autowired @Qualifier("device1") DeviceDto dev1;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("--> Application Started Successfully!!!");
		
		// salvare nel db oggetto istanziato con ruolo Admin
		userServ.create(user1);		
		
		// salvare nel db oggetto device assegnato ad utente
		deviceServ.create(dev1);
		
		deviceServ.assignDevice((long) 2, user1);
		
	}

}
