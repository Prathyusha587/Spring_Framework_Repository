package com.java.mydiaryapp.dao;

import java.util.List;

import com.java.mydiaryapp.entities.User;

public interface UserDaoInterface {
   public void save(User user);
   public void update(User user);
   public void delete(User user);
   public User findById(int userId);
   public List<User> findAllUsers();
   //method to retrieve a user details by username
   public User findByUsername(String username);
}
