package com.ytit.xyx.MySpringBootTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytit.xyx.MySpringBootTest.dao.UserDao;
import com.ytit.xyx.MySpringBootTest.doman.User;

@Service
public class UserService{

	@Autowired
	private UserDao userDao;

	//查询
	public User findUser(String username, String password) {
		System.out.println(userDao.findWithUsernameAndPassword(username, password));
		return userDao.findWithUsernameAndPassword(username, password);
	}

	public User getUserByUserName(String username) {
		return userDao.findByName(username);
	}
	
}
