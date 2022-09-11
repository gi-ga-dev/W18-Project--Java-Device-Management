package com.gigadev.deviceapp.security.auth.users;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gigadev.deviceapp.security.auth.devices.Device;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
	
	UserService userService;
	
	@GetMapping
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<List<User>> findAllDevices() {
		return ResponseEntity.ok(userService.searchAllUsers());
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	// parametro da salvare nel dto
	public ResponseEntity<User> create(@RequestBody User user) {
		return ResponseEntity.ok(userService.create(user));
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.read(id));
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> update(@RequestBody User user) {
		return ResponseEntity.ok(userService.update(user));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok("Delete successfull");
	}
}
