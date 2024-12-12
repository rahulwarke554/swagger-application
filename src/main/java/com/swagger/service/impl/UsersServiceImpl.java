package com.swagger.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swagger.entity.Address;
import com.swagger.entity.Users;
import com.swagger.service.UsersService;

@Component
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;

	@SuppressWarnings("unchecked")
	@Override
	public String AddUsersInRedis(String userJson) {
		
		redisTemplate.opsForValue().set("ADD_USER_KEY", userJson);
		
		return "Users Added In Redis Successfully...";
	}

	@Override
	public List<Users> GetAllUsersFromRedis() {
		List<Users> Users = new ArrayList<>();
		try {
			Object getUserFromRedis = redisTemplate.opsForValue().get("ADD_USER_KEY");
			
			Users = buildUsers(getUserFromRedis);
			
			
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		return Users;
	}

	private List<Users> buildUsers(Object getUserFromRedis) throws JsonProcessingException {
		List<Users> userList = new ArrayList<>();
		String redisString = (String) getUserFromRedis;
        if (redisString != null) {
            JSONArray jsonArray = new JSONArray(redisString);
            Iterator itr = jsonArray.iterator();
            while(itr.hasNext()) {
            	JSONObject obj = (JSONObject) itr.next();
            	Users user = buildUser(obj);
            	userList.add(user);
            }
        
        } else {
            System.out.println("No data found or data is not a JSON array.");
        }
		
		return userList;
	}

	private Users buildUser(JSONObject obj) {
		Users user = new Users();
		Address address = new Address();
		if(obj!=null) {
			JSONObject addressObj = obj.get("address")!=null ? (JSONObject) obj.get("address"):null;
			if(addressObj!=null) {
				if(addressObj.get("addressId")!=null)
					address.setAddressId(Long.valueOf(String.valueOf(addressObj.get("addressId"))));
				
				if(addressObj.get("street")!=null)
					address.setPinCode(String.valueOf(addressObj.get("street")));
				
				if(addressObj.get("pincode")!=null)
					address.setPinCode(String.valueOf(addressObj.get("pincode")));
				
				user.setAddress(address);
			}
			
			if(obj.get("userID")!=null)
				user.setUserId(Long.valueOf(String.valueOf(obj.get("userID"))));
			
			if(obj.get("name")!=null)
				user.setName(String.valueOf(obj.get("name")));
			
			if(obj.get("gender")!=null)
				user.setGender(String.valueOf(obj.get("name")));
			
			if(obj.get("dateOfBirth")!=null)
				user.setDob(String.valueOf(obj.get("dateOfBirth")));	
		}
		
		return user;
	}

	@Override
	public String GetuserById(String userId) throws JsonProcessingException {
		
		String getUserFromRedis = (String) redisTemplate.opsForValue().get("ADD_USER_KEY");
		
		List<Users> Users = buildUsers(getUserFromRedis);
		
		JSONObject userIdObj = new JSONObject(userId);
		
		List<Users> foundedUser = Users.stream()
				.filter(u->u.getUserId() == userIdObj.getLong("userId"))
				.collect(Collectors.toList());
		
		return foundedUser.toString();
	}

}
