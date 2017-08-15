package com.ducla.TestPersistencePoc.service;

import com.ducla.TestPersistencePoc.model.User;

public class UserBuilder {

	private String name;
	private int age;

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public User build() {
		return new User(name, age);
	}

}
