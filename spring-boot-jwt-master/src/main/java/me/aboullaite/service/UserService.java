package me.aboullaite.service;

import java.util.List;

import me.aboullaite.model.User;

public interface UserService {
	User save(User user);

	User findByEmail(String email);
	List<User> findAll();

}
