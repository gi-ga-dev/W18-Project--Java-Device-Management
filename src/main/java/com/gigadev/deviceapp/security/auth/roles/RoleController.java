package com.gigadev.deviceapp.security.auth.roles;

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
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired RoleService roleServ;
	
	@GetMapping
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<List<Role>> findAllRoles() {
		return ResponseEntity.ok(roleServ.searchAllRoles());
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	// parametro da salvare nel dto
	public ResponseEntity<Role> create(@RequestBody Role role) {
		return ResponseEntity.ok(roleServ.create(role));
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<Role> findById(@PathVariable Long id) {
		return ResponseEntity.ok(roleServ.read(id));
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Role> update(@RequestBody Role role) {
		return ResponseEntity.ok(roleServ.update(role));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		roleServ.delete(id);
		return ResponseEntity.ok("Delete successfull");
	}

}
