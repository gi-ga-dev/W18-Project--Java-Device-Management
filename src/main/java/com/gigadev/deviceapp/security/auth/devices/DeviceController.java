package com.gigadev.deviceapp.security.auth.devices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/devices")
public class DeviceController {
	
	@Autowired DeviceService deviceService;
	
	@GetMapping
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<List<Device>> findAllDevices() {
		return ResponseEntity.ok(deviceService.searchAllDevices());
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	// parametro da salvare nel dto
	public ResponseEntity<Device> create(@RequestBody DeviceDto dto) {
		return ResponseEntity.ok(deviceService.create(dto));
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<Device> findById(@PathVariable Long id) {
		return ResponseEntity.ok(deviceService.read(id));
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> update(@RequestBody Device device) {
		return ResponseEntity.ok(deviceService.update(device));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		deviceService.delete(id);
		return ResponseEntity.ok("Delete successfull");
	}
}
