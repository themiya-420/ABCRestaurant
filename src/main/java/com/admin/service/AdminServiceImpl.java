package com.admin.service;

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
import com.services.model.Service;
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
        
        try {
			createServiceTable();
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
    
    public static void createServiceTable() throws SQLException, IOException, ParserConfigurationException, ClassNotFoundException, SAXException {
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(QueryUtil.QueryById(CommonConstants.Create_Service_Table));
            System.out.println("Services Table created");
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

	@Override
	public ArrayList<Admin> getAdmins() {
		// TODO Auto-generated method stub
		ArrayList<Admin> AdminList = new ArrayList<Admin>();
		
		try {
			
			  connection = DBConnection.getConnection();
	          preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_admins));

	          ResultSet rs = preparedStatement.executeQuery();
	          
	          while(rs.next() ) {
	        	  
	        	  Admin admin = new Admin();
	        	  
	        	  admin.setId(rs.getString(CommonConstants.Column_Index_one));
	        	  admin.setUsername(rs.getString(CommonConstants.Column_Index_two));
	        	  admin.setPassword(rs.getString(CommonConstants.Column_Index_three));
	        	  admin.setRole(rs.getString(CommonConstants.Column_Index_four));
	        	  
	        	  AdminList.add(admin);
	        	 
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
		
		return AdminList;
	}

	@Override
	public ArrayList<Admin> getAdminByID(String id) {
		// TODO Auto-generated method stub
		
		ArrayList<Admin> AdminList = new ArrayList<Admin>();
		
		try {
			
			  connection = DBConnection.getConnection();
	          preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_admin_byid));
	          preparedStatement.setString(CommonConstants.Column_Index_one, id);
	          ResultSet rs = preparedStatement.executeQuery();
	          
	          while(rs.next() ) {
	        	  
	        	  Admin admin = new Admin();
	        	  
	        	  admin.setId(rs.getString(CommonConstants.Column_Index_one));
	        	  admin.setUsername(rs.getString(CommonConstants.Column_Index_two));
	        	  admin.setPassword(rs.getString(CommonConstants.Column_Index_three));
	        	  admin.setRole(rs.getString(CommonConstants.Column_Index_four));
	        	  
	        	  AdminList.add(admin);
	        	 
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
		
		return AdminList;
	}

	@Override
	public void updateAdmin(String id, Admin admin) {
		// TODO Auto-generated method stub
		
		try {

            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.update_admin));

            connection.setAutoCommit(false);
            
            System.out.print(id);

            
            // Hash the password before saving
            String hashedPassword = CommonUtil.hashPassword(admin.getPassword());
            admin.setPassword(hashedPassword);
            

            preparedStatement.setString(CommonConstants.Column_Index_one, admin.getUsername());
            preparedStatement.setString(CommonConstants.Column_Index_two, admin.getPassword());
            preparedStatement.setString(CommonConstants.Column_Index_three, admin.getRole());
            preparedStatement.setString(CommonConstants.Column_Index_four, admin.getId());

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
	public void deleteAdmin(String id) {
		// TODO Auto-generated method stub
		
		if (id != null && !id.isEmpty()) {
			
			try {
				
				connection = DBConnection.getConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.delete_admin));
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

	@Override
	public void addService(Service service) {
		// TODO Auto-generated method stub
		try {

            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.add_service));

            connection.setAutoCommit(false);

            preparedStatement.setString(CommonConstants.Column_Index_one, service.getName());
            preparedStatement.setString(CommonConstants.Column_Index_two, service.getCategory());
            preparedStatement.setString(CommonConstants.Column_Index_three, service.getAvailability());
            preparedStatement.setString(CommonConstants.Column_Index_four, service.getPrice());
            preparedStatement.setString(CommonConstants.Column_Index_five, service.getImage());
            preparedStatement.setString(CommonConstants.Column_Index_six, service.getDetails());

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
	public ArrayList<Service> getSerivices() {
		// TODO Auto-generated method stub
		ArrayList<Service> ServiceList = new ArrayList<Service>();
		
		try {
			
			  connection = DBConnection.getConnection();
	          preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_services));

	          ResultSet rs = preparedStatement.executeQuery();
	          
	          while(rs.next() ) {
	        	  
	        	  Service service = new Service();
	        	  
	        	  service.setId(rs.getString(CommonConstants.Column_Index_one));
	        	  service.setName(rs.getString(CommonConstants.Column_Index_two));
	        	  service.setCategory(rs.getString(CommonConstants.Column_Index_three));
	        	  service.setAvailability(rs.getString(CommonConstants.Column_Index_four));
	        	  service.setPrice(rs.getString(CommonConstants.Column_Index_five));
	        	  service.setImage(rs.getString(CommonConstants.Column_Index_six));
	        	  service.setDetails(rs.getString(CommonConstants.Column_Index_seven));
	        	  
	        	  
	        	  ServiceList.add(service);
	        	 
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
		
		return ServiceList;
	}

	@Override
	public ArrayList<Service> getServiceById(String id) {
		// TODO Auto-generated method stub
	ArrayList<Service> ServiceList = new ArrayList<Service>();
		
		try {
			
			  connection = DBConnection.getConnection();
	          preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.get_service_byid));
	          preparedStatement.setString(CommonConstants.Column_Index_one, id);
	          ResultSet rs = preparedStatement.executeQuery();
	          
	          while(rs.next() ) {
	        	  
	        	  Service service = new Service();
	        	  
	        	  service.setId(rs.getString(CommonConstants.Column_Index_one));
	        	  service.setName(rs.getString(CommonConstants.Column_Index_two));
	        	  service.setCategory(rs.getString(CommonConstants.Column_Index_three));
	        	  service.setAvailability(rs.getString(CommonConstants.Column_Index_four));
	        	  service.setPrice(rs.getString(CommonConstants.Column_Index_five));
	        	  service.setImage(rs.getString(CommonConstants.Column_Index_six));
	        	  service.setDetails(rs.getString(CommonConstants.Column_Index_seven));
	        	  
	        	  
	        	  ServiceList.add(service);
	        	 
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
		
		return ServiceList;
	}

	@Override
	public void updateService(String id, Service service) {
	    try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.update_service));

	        connection.setAutoCommit(false);

	        System.out.println(id + " This is from the AdminServices Update Service ");
	        
	        System.out.println("Name: " + service.getName());
	        
	        service.setId(id);

	        preparedStatement.setString(CommonConstants.Column_Index_one, service.getName());
	        preparedStatement.setString(CommonConstants.Column_Index_two, service.getCategory());
	        preparedStatement.setString(CommonConstants.Column_Index_three, service.getAvailability());
	        preparedStatement.setString(CommonConstants.Column_Index_four, service.getPrice());
	        preparedStatement.setString(CommonConstants.Column_Index_five, service.getImage());
	        preparedStatement.setString(CommonConstants.Column_Index_six, service.getDetails());
	        preparedStatement.setString(CommonConstants.Column_Index_seven, service.getId());

	        int rowsAffected = (int) preparedStatement.executeLargeUpdate();
	        connection.commit();
	        
	        System.out.println("Executing query: " + preparedStatement.toString());

	        if (rowsAffected > 0) {
	            System.out.println("Query executed successfully. Rows affected: " + rowsAffected);
	        } else {
	            System.out.println("No rows were affected by the update query.");
	        }

	    } catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
	        System.out.println("Connection error: " + e.getMessage());
	    } finally {
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("SQL error: " + e.getMessage());
	        }
	    }
	}


	@Override
	public void deleteService(String id) {
		// TODO Auto-generated method stub
		
		if (id != null && !id.isEmpty()) {
			
			try {
				
				connection = DBConnection.getConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.QueryById(CommonConstants.delete_service));
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

}
