package com.gigadev.deviceapp.security.auth.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.gigadev.deviceapp.security.auth.devices.Device;
import com.gigadev.deviceapp.security.auth.devices.DeviceDto;
import com.gigadev.deviceapp.security.auth.roles.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@Size(max = 30)
	private String fullName;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	// i device salvati nella collection dell'utente verranno salvati a loro volta (PERSIST) 
	// nella colonna user_id del table devices (@JoinColumn)
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private List<Device> devices = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	// il table user_roles deve contenere i dati associati di user_id e role_id
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();

	public User(@NotBlank @Size(max = 20) String username, @Size(max = 30) String fullName,
			@NotBlank @Size(max = 120) String password) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
	}	
	
	public void addDevice(Device device) {
		devices.add(device);
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}

}
