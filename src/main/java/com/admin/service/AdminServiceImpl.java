package com.admin.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.admin.model.Admin;
import com.user.util.CommonConstants;
import com.user.util.CommonUtil;
import com.user.util.DBConnection;
import com.user.util.QueryUtil;

public class  AdminServiceImpl implements IAdminService{
	
	private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    static {

        try {
			createAdminTable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    public static void createAdminTable() throws SQLException, IOException, ParserConfigurationException, ClassNotFoundException, SAXException {
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(QueryUtil.QueryById(CommonConstants.Create_Admin_Table));
        } catch (SQLException | IOException |ParserConfigurationException | ClassNotFoundException | SAXException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {

                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e){
                System.out.println("SQL error" + e.getMessage());
            }
        }
    }

	@Override
	public void adminSignup(Admin admin) {
		// TODO Auto-generated method stub
		
		try {

            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.signup_admin));

            connection.setAutoCommit(false);

            
            // Hash the password before saving
            String hashedPassword = CommonUtil.hashPassword(admin.getPassword());
            admin.setPassword(hashedPassword);
            

            preparedStatement.setString(CommonConstants.Column_Index_one, admin.getUsername());
            preparedStatement.setString(CommonConstants.Column_Index_two, admin.getPassword());
            preparedStatement.setString(CommonConstants.Column_Index_three, admin.getRole());

            preparedStatement.executeLargeUpdate();
            connection.commit();

        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {

            System.out.println("Connection error" + e.getMessage());
        } finally {
            try {
                if (connection != null) {

                    connection.close();
                }
                if (preparedStatement != null) {
                	preparedStatement.close();
                }
            } catch (SQLException e){
                System.out.println("SQL error" + e.getMessage());
            }
        }
		
	}

	@Override
	public String adminSignin(String username, String password) {
		// TODO Auto-generated method stub
		
		String role = null;
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.signin_admin));

	        preparedStatement.setString(1, username);

	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            String storedPassword = resultSet.getString("password");

	            // Assuming passwords are stored in a hashed form, use a method to validate the hash
	            if (CommonUtil.validatePassword(password, storedPassword)) {
	                role = resultSet.getString("role"); // Get the role from the result set
	            }
	        }

	    } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
	        System.out.println("Connection error: " + e.getMessage());
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("SQL error: " + e.getMessage());
	        }
	    }

	    return role;
		
	}

}
