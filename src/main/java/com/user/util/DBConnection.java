package com.user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends CommonUtil {
	
	 private static Connection connection;

	    private DBConnection() {

	    }

	    public static Connection getConnection() throws ClassNotFoundException, SQLException {

	        if (connection == null || connection.isClosed() ) {
	            Class.forName(properties.getProperty(CommonConstants.Driver_Name));
	            connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
	                    properties.getProperty(CommonConstants.UserName),properties.getProperty(CommonConstants.Password));
	        }

	        return connection;
	    }

}
