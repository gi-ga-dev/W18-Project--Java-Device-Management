package com.gigadev.deviceapp.security.auth.users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
public class UserService {
	
	@Autowired UserRepository userRepository;
	
	public List<UserResponse> getAllUsersBasicInformations() {
		return userRepository.findAll()
				.stream()
				.map( user ->  UserResponse
								.builder()
								.userName(  user.getUsername()  )
								.role( user.getRoles().stream().findFirst().get().getRoleName().name() )
								.build()   
				).collect(Collectors.toList());
	}
	
	public UserResponse getUserBasicInformations(String userName) {
		User user = userRepository.findByUsername(userName).get();		
		
		return UserResponse
		.builder()
		.userName(userName)
		.role( user.getRoles().stream().findFirst().get().getRoleName().name()).build();		
	}
	
	public List<User> searchAllUsers() {
		if(userRepository.findAll() == null) {
			throw new EntityNotFoundException("No results found...");
		} else return (List<User>) userRepository.findAll();
	}
		
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public User read(Long id) {
		if(!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found...");
		} else return userRepository.findById(id).get();
	}
	
	public User update(User user) {		
		if(userRepository.existsById(user.getId())) {
			throw new EntityNotFoundException("User already exist...");
		} else return userRepository.save(user);		
	}
	
	public void delete(Long id) {
		// se non esiste l'id lancia eccezione, altrimenti elimina dal db
		if(!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found...");
		} else userRepository.deleteById(id);		
	}
	

}
