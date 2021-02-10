package org.hcl.handleauthentication.controller;

import org.hcl.handleauthentication.crudRepository.UserCrudRepo;
import org.hcl.handleauthentication.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private UserCrudRepo userCrudRepo;
	
	@GetMapping("/login")
	public String loginUser(@RequestParam String name, @RequestParam String password) {
		if (name == null) {
			return "false";
		} else if (password ==null) {
			return "false";
		}
		
		Iterable<UserEntity> AllUsers = userCrudRepo.findAll();
		for (UserEntity u : AllUsers) {
			if (u.getName().equals(name)) {
				if (u.getPassword().equals(password)) {
					return "true";
				}
			}
		}
		
		return "false";
	}
	
	@GetMapping("/mock")
	public String mockMethod() {
		return "Hello";
	}
}
