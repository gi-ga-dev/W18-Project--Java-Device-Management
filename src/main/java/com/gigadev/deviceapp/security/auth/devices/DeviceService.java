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

	@Autowired
	@Qualifier("admin1")
	Role adminRole;
	@Autowired
	@Qualifier("employee1")
	Role employeeRole;
	@Autowired
	@Qualifier("visitor1")
	Role visitorRole;

	@Autowired
	private DeviceRepository deviceRepo;

	// ritorna device con utente assegnato
	public Device assignDevice(Long id, User user) {
		Device device = read(id);		
		device.setUser(user);
		device.setDeviceStatus(DeviceStatus.ASSIGNED);
		user.addDevice(device);
		update(device);
		System.out.println("______________" + user.getDevices().size());
		return device;
	}

	public List<Device> searchAllDevices() {
		if (deviceRepo.findAll() == null) {
			throw new EntityNotFoundException("No results found...");
		} else
			return (List<Device>) deviceRepo.findAll();
	}

	public Device create(DeviceDto dto) {		
		// creo oggetto vuoto e gli copio le proprieta' della classe dto (custom)
		Device dev1 = new Device();
		BeanUtils.copyProperties(dto, dev1);
		deviceRepo.save(dev1);		
		return dev1;
	}

	public Device read(Long id) {
		if (!deviceRepo.existsById(id)) {
			throw new EntityNotFoundException("Device not found...");
		} else
			return deviceRepo.findById(id).get();
	}

	public Device update(Device device) {
		return deviceRepo.save(device);
	}

	public void delete(Long id) {
		// se non esiste l'id lancia eccezione, altrimenti elimina dal db
		if (!deviceRepo.existsById(id)) {
			throw new EntityNotFoundException("Device not found...");
		} else
			deviceRepo.deleteById(id);
	}

}
