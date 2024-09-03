package com.admin.service;

import java.util.ArrayList;

import com.admin.model.Admin;
import com.user.model.User;

public interface IAdminService {
	
	public void adminSignup(Admin admin);
	
	public String adminSignin(String username, String password);
	
	 public ArrayList<Admin> getAdmins();
	 
	 public ArrayList<Admin> getAdminByID(String id);
	 
	 public void updateAdmin(String id, Admin admin);
	 
	 public void deleteAdmin(String id);

}
