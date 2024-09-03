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

import com.admin.model.Admin;
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
            
            // Hash the password before saving
            String hashedPassword = CommonUtil.hashPassword(user.getPassword());
            user.setPassword(hashedPassword);
            

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
		ArrayList<User> UserList = new ArrayList<User>();
		
		try {
			
			  connection = DBConnection.getConnection();
	          preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_users));

	          ResultSet rs = preparedStatement.executeQuery();
	          
	          while(rs.next() ) {
	        	  
	        	  User user = new User();
	        	  
	        	  user.setId(rs.getString(CommonConstants.Column_Index_one));
	        	  user.setUsername(rs.getString(CommonConstants.Column_Index_two));
	        	  user.setPassword(rs.getString(CommonConstants.Column_Index_three));
	        	  user.setEmail(rs.getString(CommonConstants.Column_Index_four));
	        	  user.setPhone(rs.getString(CommonConstants.Column_Index_five));
	        	  user.setRole(rs.getString(CommonConstants.Column_Index_six));
	        	  
	        	  UserList.add(user);
	        	 
	          }
			
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {

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
		
		return UserList;
	}

	@Override
	public ArrayList<User> getUserById(String id) {
		// TODO Auto-generated method stub
		ArrayList<User> UserList = new ArrayList<User>();
		
		try {
			
			  connection = DBConnection.getConnection();
	          preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_user_byid));
	          preparedStatement.setString(CommonConstants.Column_Index_one, id);
	          ResultSet rs = preparedStatement.executeQuery();
	          
	          while(rs.next() ) {
	        	  
	        	  User user = new User();
	        	  
	        	  user.setId(rs.getString(CommonConstants.Column_Index_one));
	        	  user.setUsername(rs.getString(CommonConstants.Column_Index_two));
	        	  user.setPassword(rs.getString(CommonConstants.Column_Index_three));
	        	  user.setEmail(rs.getString(CommonConstants.Column_Index_four));
	        	  user.setPhone(rs.getString(CommonConstants.Column_Index_five));
	        	  user.setRole(rs.getString(CommonConstants.Column_Index_six));
	        	  
	        	  UserList.add(user);
	        	 
	          }
			
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {

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
		
		return UserList;
	}

	@Override
	public void updateUser(String id, User user) {
		// TODO Auto-generated method stub
	
		
		try {

			connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.update_user));

            connection.setAutoCommit(false);

        
            
            // Hash the password before saving
            String hashedPassword = CommonUtil.hashPassword(user.getPassword());
            user.setPassword(hashedPassword);
            

           
            preparedStatement.setString(CommonConstants.Column_Index_one, user.getUsername());
            preparedStatement.setString(CommonConstants.Column_Index_two, user.getPassword());
            preparedStatement.setString(CommonConstants.Column_Index_three, user.getEmail());
            preparedStatement.setString(CommonConstants.Column_Index_four, user.getPhone());
            preparedStatement.setString(CommonConstants.Column_Index_five, user.getRole());
            preparedStatement.setString(CommonConstants.Column_Index_six, user.getId());

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
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	if (id != null && !id.isEmpty()) {
			
			try {
				
				connection = DBConnection.getConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.delete_user));
				preparedStatement.setString(CommonConstants.Column_Index_one, id);
				
				preparedStatement.execute();
				
	        } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				
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
	public boolean userSingIn(String email, String password) {
		// TODO Auto-generated method stub
		
		   boolean isAuthenticated = false;

		    try {
		        connection = DBConnection.getConnection();
		        preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.signin_user));

		        preparedStatement.setString(1, email);

		        ResultSet resultSet = preparedStatement.executeQuery();

		        if (resultSet.next()) {
		            String storedPassword = resultSet.getString("password");

		            // Assuming passwords are stored in a hashed form, use a method to validate the hash
		            if (CommonUtil.validatePassword(password, storedPassword)) {
		                isAuthenticated = true;
		            }
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
		        } catch (SQLException e) {
		            System.out.println("SQL error" + e.getMessage());
		        }
		    }

		    return isAuthenticated;
	}


	
}
