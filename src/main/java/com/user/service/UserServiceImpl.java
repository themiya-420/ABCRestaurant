package com.user.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.user.model.User;
import com.user.util.CommonConstants;
import com.user.util.CommonUtil;
import com.user.util.DBConnection;
import com.user.util.QueryUtil;

public class UserServiceImpl implements IUserService {
	
	private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    static {

        try {
			createUserTable();
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

    public static void createUserTable() throws SQLException, IOException, ParserConfigurationException, ClassNotFoundException, SAXException {
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(QueryUtil.QueryById(CommonConstants.Create_User_Table));
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
	public void userSignUp(User user) {
		// TODO Auto-generated method stub
		

        String userid = CommonUtil.generateUserIds(getUserIds());

        try {

            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.signup_user));

            connection.setAutoCommit(false);

            user.setId(userid);

            preparedStatement.setString(CommonConstants.Column_Index_one, user.getId());
            preparedStatement.setString(CommonConstants.Column_Index_two, user.getUsername());
            preparedStatement.setString(CommonConstants.Column_Index_three, user.getPassword());
            preparedStatement.setString(CommonConstants.Column_Index_four, user.getEmail());
            preparedStatement.setString(CommonConstants.Column_Index_five, user.getPhone());
            preparedStatement.setString(CommonConstants.Column_Index_six, user.getRole());

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
	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getUserById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(String id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}
	
	
	  public ArrayList<String> getUserIds() {

	        ArrayList<String> userIds = new ArrayList<>();

	        try {

	            connection = DBConnection.getConnection();
	            preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_user_ids));

	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                userIds.add(rs.getString(CommonConstants.Column_Index_one));
	            }


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


	        return userIds;


	    }

	@Override
	public void userSingIn(User user) {
		// TODO Auto-generated method stub
		
	}

}
