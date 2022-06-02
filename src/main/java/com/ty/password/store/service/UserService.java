package com.ty.password.store.service;

import com.ty.password.store.dao.UserDao;
import com.ty.password.store.dto.User;

public class UserService {

	UserDao userDao=new UserDao();
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
}
