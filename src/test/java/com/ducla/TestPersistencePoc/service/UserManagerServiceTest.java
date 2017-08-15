package com.ducla.TestPersistencePoc.service;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ducla.TestPersistencePoc.dao.UserDao;
import com.ducla.TestPersistencePoc.model.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
public class UserManagerServiceTest {

	private List<User> users = new ArrayList<User>();
	private List<User> validUsers = new ArrayList<User>();

	@Mock
	private UserDao dao;

	@InjectMocks
	private UserManagerService service;

	@BeforeClass
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
	}

	private void setUpNoUserScenario() {
		reset(dao);
		when(dao.getAll()).thenReturn(users);
		// ReflectionTestUtils.setField(service, "dao", dao);
	}

	private void setUpUsersAreThereScenario() {
		validUsers.add(new UserBuilder().setName("test1").setAge(10).build());
		validUsers.add(new UserBuilder().setName("test2").setAge(20).build());
		reset(dao);
		when(dao.getAll()).thenReturn(validUsers);
		// ReflectionTestUtils.setField(service, "dao", dao);
	}

	@Test(enabled = true)
	public void noUserThere() {
		setUpNoUserScenario();
		assertEquals(service.getUsers().size(), 0);
	}

	@Test(enabled = true)
	public void userAreThere() {
		setUpUsersAreThereScenario();
		assertEquals(service.getUsers().size(), 2);
	}
}
