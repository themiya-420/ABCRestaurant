package com.user.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;

public class CommonUtil {
	
	public static final Properties properties = new Properties();
	
	static {
		
		try {
			
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.Property_File));
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	 public static String generateUserIds(ArrayList<String> ids) {
	        String id;

	        int next = ids.size();

	        id = CommonConstants.user_id_prefix + next;

	        if (ids.contains(id)){
	            next++;
	            id = CommonConstants.user_id_prefix + next;
	        }

	        return id;
	    }
	 
	 public static String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] hashedBytes = md.digest(password.getBytes());

	            StringBuilder sb = new StringBuilder();
	            for (byte b : hashedBytes) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 public static boolean validatePassword(String rawPassword, String storedHash) {
	        String hashedPassword = hashPassword(rawPassword);
	        return hashedPassword.equals(storedHash);
	    }

}
