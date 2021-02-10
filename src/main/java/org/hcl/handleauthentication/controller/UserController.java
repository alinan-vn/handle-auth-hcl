package org.hcl.handleauthentication.controller;

import org.hcl.handleauthentication.crudRepository.UserCrudRepo;
import org.hcl.handleauthentication.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserCrudRepo userCrudRepo;
	
	@GetMapping("/users")
	public Iterable<UserEntity>getUsers() {
		return userCrudRepo.findAll();
	}
	
	@PostMapping("/createUser")
	public UserEntity createUser(@RequestBody UserEntity userDetails) {	
		return userCrudRepo.save(userDetails);
	}
	
	@PostMapping("/login")
	public boolean loginUser(@RequestBody UserEntity userDetails) {
		if (userDetails == null) {
			return false;
		} else if (userDetails.getName() == null) {
			return false;
		} else if (userDetails.getPassword() ==null) {
			return false;
		}
		
		Iterable<UserEntity> AllUsers = userCrudRepo.findAll();
		for (UserEntity u : AllUsers) {
			if (u.getName().equals(userDetails.getName())) {
				if (u.getPassword().equals(userDetails.getPassword())) {
					return true;
				}
			}
		}
		
		return false;
	}
}
