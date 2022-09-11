package com.gigadev.deviceapp.security.auth.devices;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepo;
	
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
