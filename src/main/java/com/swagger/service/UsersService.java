package com.swagger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swagger.entity.Users;


@Service
public interface UsersService {

	public String AddUsersInRedis(String userJson);

	public List<Users> GetAllUsersFromRedis();
	

}
