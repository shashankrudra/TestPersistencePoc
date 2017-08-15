package com.ducla.TestPersistencePoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducla.TestPersistencePoc.dao.UserDao;
import com.ducla.TestPersistencePoc.model.User;

@Service
public class UserManagerService {

	@Autowired
	private UserDao dao;

	public int getUserCount()

	{
		List<User> users = getUsers();

		if (users != null)
			return users.size();
		return 0;
	}

	public List<User> getUsers() {
		return dao.getAll();
	}

}
