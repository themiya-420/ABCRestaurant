package com.user.util;

import java.io.IOException;
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

}
