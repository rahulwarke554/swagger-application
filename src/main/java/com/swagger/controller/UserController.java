package com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.entity.Users;
import com.swagger.service.UsersService;

@RestController
@RequestMapping("/api/user-controller")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/addUsers")
	public ResponseEntity<String> AddUsers(@RequestBody String userJson) {
		
		String response = usersService.AddUsersInRedis(userJson);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getUsers")
	public List<Users> GetAllUsers(){
		List<Users> getUserResponse = usersService.GetAllUsersFromRedis();
		
		return getUserResponse;
	}

}
