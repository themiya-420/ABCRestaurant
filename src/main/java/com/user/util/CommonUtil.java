package com.user.util;

import java.io.IOException;
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

}
