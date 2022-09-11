package com.gigadev.deviceapp.security.auth.devices;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gigadev.deviceapp.security.auth.roles.Role;
import com.gigadev.deviceapp.security.auth.users.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeviceService {
	
	@Autowired @Qualifier("admin1") Role adminRole;
	@Autowired @Qualifier("employee1") Role employeeRole;
	@Autowired @Qualifier("visitor1") Role visitorRole;
	
	@Autowired
	private DeviceRepository deviceRepo;
	
	// ritorna device con utente assegnato
	public Device assignDevice(Device device, User user) {	
		
		// se la lista ruoli utente del parametro contiene un oggetto ruolo EMPLOYEE o ADMIN (adminRole/emplRole)
		if(!user.getRoles().contains(employeeRole) || !user.getRoles().contains(adminRole) ) {
			device.setUser(user);	
			device.setDeviceStatus(DeviceStatus.ASSIGNED);
			user.addDevice(device);
			System.out.println("______________" + user.getDevices().size());
			
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
	
	public List<Device> searchAllDevices() {
		if(deviceRepo.findAll() == null) {
			throw new EntityNotFoundException("No results found...");
		} else return (List<Device>) deviceRepo.findAll();
	}
		
	public Device create(Device device) {
		
		// creo oggetto vuoto e gli copio le proprieta' della classe dto (custom)
//		Device dev1 = new Device();
//		BeanUtils.copyProperties(device, dev1);
		return deviceRepo.save(device);
//		return dev1;
			
	}
	
	public Device read(Long id) {
		if(!deviceRepo.existsById(id)) {
			throw new EntityNotFoundException("Device not found...");
		} else return deviceRepo.findById(id).get();
	}
	
	public Device update(Device device) {		
		return deviceRepo.save(device);		
	}
	
	public void delete(Long id) {
		// se non esiste l'id lancia eccezione, altrimenti elimina dal db
		if(!deviceRepo.existsById(id)) {
			throw new EntityNotFoundException("Device not found...");
		} else deviceRepo.deleteById(id);		
	}

}
