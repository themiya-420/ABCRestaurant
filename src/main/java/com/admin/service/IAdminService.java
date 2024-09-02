package com.admin.service;

import com.admin.model.Admin;

public interface IAdminService {
	
	public void adminSignup(Admin admin);
	
	public String adminSignin(String username, String password);

}
