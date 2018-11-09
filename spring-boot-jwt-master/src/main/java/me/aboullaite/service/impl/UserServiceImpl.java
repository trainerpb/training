package me.aboullaite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.aboullaite.dao.UserDao;
import me.aboullaite.model.User;
import me.aboullaite.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User save(User user) {
		return userDao.save(user);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>)userDao.findAll();
	}
	
}
