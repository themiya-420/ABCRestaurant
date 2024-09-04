package com.admin.service;

import java.util.ArrayList;

import com.admin.model.Admin;
import com.services.model.Service;

public interface IAdminService {
	
	public void adminSignup(Admin admin);
	
	public String adminSignin(String username, String password);
	
	 public ArrayList<Admin> getAdmins();
	 
	 public ArrayList<Admin> getAdminByID(String id);
	 
	 public void updateAdmin(String id, Admin admin);
	 
	 public void deleteAdmin(String id);
	 
	 public void addService(Service service);
	 
	 public ArrayList<Service> getSerivices();
	 
	 public ArrayList<Service> getServiceById(String id);
	 
	 public void updateService(String id, Service service);
	 
	 public void deleteService(String id);
	 

}
