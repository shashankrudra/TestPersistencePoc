package com.ducla.TestPersistencePoc.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ducla.TestPersistencePoc.model.User;

public class DataProviderTest {

	private String filePath;

	@DataProvider(name = "users")
	public static Object[] credentials() {
		User user1 = new UserBuilder().setName("test1").setAge(10).build();
		User user2 = new UserBuilder().setName("test2").setAge(20).build();
		return new Object[] { user1, user2 };
	}

	@Test(dataProvider = "users")
	public void testUsers(User user) {
		System.out.println(user);
	}

	@DataProvider
	public Iterator<Object[]> testData() throws IOException {
		final List<Object[]> list = new ArrayList<>();

		for (final String line : Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			list.add(new Object[] { line, process(line) });
		}

		return list.iterator();
	}

	private Object process(String line) {
		return line.charAt(0);
	}

}
