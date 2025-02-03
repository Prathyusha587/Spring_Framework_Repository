package com.java.mydiaryapp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.java.mydiaryapp.dao.UserDaoInterface;
import com.java.mydiaryapp.entities.User;

@Component
public class UserBusinessLayerImpl implements UserBusinessLayerInterface {

	// connect to dao and its interfaces
	@Autowired
	private UserDaoInterface userDaoInterface;

	public UserDaoInterface getUserInterface() {
		return userDaoInterface;
	}

	public void setUserInterface(UserDaoInterface userInterface) {
		this.userDaoInterface = userInterface;
	}

	public void save(User user) {
		userDaoInterface.save(user);

	}

	public void update(User user) {
		userDaoInterface.update(user);
	}

	public void delete(User user) {
		userDaoInterface.delete(user);

	}

	@Override
	public User findById(int userId) {
		return userDaoInterface.findById(userId);
	}

	@Override
	public List<User> findAllUsers() {
		return userDaoInterface.findAllUsers();
	}

	
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDaoInterface.findByUsername(username);
	}

}
