package com.ducla.TestPersistencePoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ducla.TestPersistencePoc.model.User;
import com.ducla.TestPersistencePoc.service.UserManagerService;

@Component
public class AppRunner {

	@Autowired
	private UserManagerService service;

	public List<User> testService() {
		List<User> users = service.getUsers();
		System.out.println(users);
		return users;
	}

}
