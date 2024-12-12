package com.swagger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swagger.entity.Users;


@Service
public interface UsersService {

	public String AddUsersInRedis(String userJson);

	public List<Users> GetAllUsersFromRedis();

	public String GetuserById(String userId) throws JsonProcessingException;
	

}
