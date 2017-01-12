package com.raj.dao;

import java.util.List;

import com.raj.model.User;

public interface UserDAO {
	
	public List<User> list();

	public User get(int uid);
	
	public void save(User user);
	
	public void update(User user);

	public void delete(int uid);
	
}