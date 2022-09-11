package com.gigadev.deviceapp.security.auth.roles;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	
	@Autowired RoleRepository roleRepo;
	
	public List<Role> searchAllRoles() {
		if(roleRepo.findAll() == null) {
			throw new EntityNotFoundException("No results found...");
		} else return (List<Role>) roleRepo.findAll();
	}
		
	public Role create(Role role) {
		return roleRepo.save(role);
	}
	
	public Role read(Long id) {
		if(!roleRepo.existsById(id)) {
			throw new EntityNotFoundException("Role not found...");
		} else return roleRepo.findById(id).get();
	}
	
	public Role update(Role role) {		
		if(roleRepo.existsById(role.getId())) {
			throw new EntityNotFoundException("Role already exist...");
		} else return roleRepo.save(role);		
	}
	
	public void delete(Long id) {
		// se non esiste l'id lancia eccezione, altrimenti elimina dal db
		if(!roleRepo.existsById(id)) {
			throw new EntityNotFoundException("Role not found...");
		} else roleRepo.deleteById(id);		
	}

}
