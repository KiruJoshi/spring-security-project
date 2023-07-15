package com.example.springsecurity.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.configuration.AccessDeniedException;
import com.example.springsecurity.entity.Authorities;
import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repository.AuthorityRepository;
import com.example.springsecurity.repository.UsersRepository;

@RestController
@RequestMapping("/userRequest")
public class UserController {

	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("/getAllUserAndAuthority")
	public List<Authorities> getAllUserAndAuthority(Principal principal) {
	
		Users users = usersRepository.findByUsername(principal.getName());
		Authorities authorities = authorityRepository.findByUsers(users);
	
		if(authorities.getAuthority()=="CEO") {
		List<Authorities> findAll = authorityRepository.findAll();
	
		return findAll;
		}
		else {
			return (List<Authorities>) new  AccessDeniedException("You dont have permission"); 
		}
	}

	@GetMapping("/getOnlyUsers")
	public List<Users> getOnlyUsers() {
		List<Users> getUsers = usersRepository.findAll();
		return getUsers;
	}

	@GetMapping("/getSingleUsersAndAuthority/{username}")
	public Authorities getSingleUsersAndAuthority(@PathVariable Users username) {
		Authorities singleUsersAndAuthority = authorityRepository.findByUsers(username);
		return singleUsersAndAuthority;

	}

	@PostMapping("/saveUsersAndAuthorities")
	public String addUsersAndAuthorities(@RequestBody Authorities authority) {
		Users users = new Users(authority.getUsers().getUsername(), authority.getUsers().getPassword(), true);
		usersRepository.save(users);
		Authorities authorities = new Authorities(users, authority.getAuthority());
		authorityRepository.save(authorities);
		return "new user and authority saved successfully in db";
	}

	// deleting only authority
	@DeleteMapping("/delete/{username}")
	public String deleteAuthority(@PathVariable String username) {
		Users users = usersRepository.findByUsername(username);

		Authorities authorities = authorityRepository.findByUsers(users);
		authorityRepository.delete(authorities);

		return "authority deleted";

	}
	
	@DeleteMapping("/deleteUserAndAuthority/{username}")
	public String deleteUserAndAuthority(@PathVariable String username) {
		Users users = usersRepository.findByUsername(username);

		Authorities authorities = authorityRepository.findByUsers(users);
		authorityRepository.delete(authorities);
		usersRepository.delete(users);
		
		return "user and authority both deleted successfully";
	}
	
	
}
