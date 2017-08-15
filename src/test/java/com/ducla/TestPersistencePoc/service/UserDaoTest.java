package com.ducla.TestPersistencePoc.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ducla.TestPersistencePoc.dao.UserDao;
import com.ducla.TestPersistencePoc.model.User;

public class UserDaoTest {

	private List<User> users = new ArrayList<User>();
	private List<User> validUsers = new ArrayList<User>();

	@Mock
	private UserDao dao;

	@BeforeClass
	public void before() {
		dao = Mockito.mock(UserDao.class);
	}

	private void setUpNoUserScenario() {
		when(dao.getAll()).thenReturn(users);
	}

	private void setUpUsersAreThereScenario() {
		validUsers.add(new UserBuilder().setName("test1").setAge(10).build());
		validUsers.add(new UserBuilder().setName("test2").setAge(20).build());
		when(dao.getAll()).thenReturn(validUsers);
	}

	@Test(enabled = true, dependsOnMethods = { "userAreThere" })
	public void noUserThere() {
		setUpNoUserScenario();
		assertEquals(dao.getAll().size(), 0);
	}

	@Test(enabled = true)
	public void userAreThere() {
		setUpUsersAreThereScenario();
		assertEquals(dao.getAll().size(), 2);
		verify(dao, times(1)).getAll();
	}

}
