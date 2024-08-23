package com.user.service;

import java.util.ArrayList;

import com.user.model.User;

public interface IUserService {
	
	  public void userSignUp(User user);
	  
	  public boolean userSingIn(String email, String password);

	    public ArrayList<User> getUsers();

	    public ArrayList<User> getUserById();

	    public void updateUser(String id, User user);

	    public void deleteUser(String id);

}
