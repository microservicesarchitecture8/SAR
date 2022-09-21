package com.sar.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sar.user.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	// fake user list
	List<User> list = List.of(
			new User(1311, "Ankit", "9919829"),
			new User(1231, "Rahul", "3459829"),
			new User(1321, "Aman", "3423511")
	);

	@Override
	public User getuser(int id) {
		return this.list.stream().filter(user -> user.getUserId()==id).findAny().orElse(null);
	}
}
